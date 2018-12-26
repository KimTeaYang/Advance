package net.day01;

import java.net.*;
import java.io.*;
/* TCP��� ����� �̿��� ����ϴ� ���α׷��� �ۼ��սô�.
 *  - ������
 *   [1] ServerScocket
 *   [2] Socket
 *   �ΰ����� �ʿ�!
 * */

public class MyNetServer {

	public static void main(String[] args) 
	throws IOException {
		
		/* 0~1024�� ����� ��Ʈ. 1024�̻� 65535���Ϸ� �����ϴ� ���� ����. */
		final int port = 5555;
		
		// 1. ���� ������ ����=> ��Ʈ��ȣ �ʿ�
		ServerSocket server = new ServerSocket(port);
		System.out.println("MyNetServer�����...");			
		
		while(true) {
			Socket sock = server.accept();
			/* Client�� �����ؼ� ������ ���������� Client�� ����� ����
			 * ��ü�� ��ȯ���ش�. */
			System.out.println("Client�� �����ؿ�");
			
			InetAddress ia = sock.getInetAddress();
			String cip = ia.getHostAddress();
			System.out.println("Client IP: "+cip);
			
			int num = (int)(Math.random()*100+1);
			
			OutputStream os = sock.getOutputStream();
			// client���� ���ڸ� �����ϱ� ���� ��½�Ʈ��(���)�� ��´�.
			DataOutputStream dos = new DataOutputStream(os);
			// �ڷ� �������� ���͸�
			dos.writeInt(num);
			dos.flush();
			
			InputStream is = sock.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			
			String msg = dis.readUTF();
			System.out.println("client MSG: "+msg);
			
			dis.close();
			is.close();
			dos.close();
			os.close();
			sock.close();
		}
	}
}
