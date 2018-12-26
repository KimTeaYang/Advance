package net.day01;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
/*[������ ����]
 * - Client�� Server�� �����ϸ�
 * [1] ������ Ŭ���� "�ȳ��ϼ���? Ŭ���̾�Ʈ��~~"
 *    �̶� �޽����� ������.
 *    
 * [2] �׷��� Ŭ���̾�Ʈ�� Ű���� �Է��� ����
 *     �������� �޽����� ������.
 *     
 * [3] ������ Ŭ�� ������ �޽����� �м��ؼ�
 *     <1> "�ȳ��ϼ���?" �Ǵ� "����"�� �޽����� ����
 *       ==> "�ݰ�����~ Ŭ��!" �̶� �亯�ϰ�
 *     <2> "���� ��¥��" �̶� �޽����� ����
 *      ==> ���� ��¥�� �˷��ְ�
 *     <3> �� �� �ٸ� �޽����� ����
 *     ==> " ~�� � ��!!"�� �޽����� ������.   
 * */
public class EchoServer {
	
	
	public static void main(String[] args) 
	throws IOException {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(d);
		
		final int port = 7777;
		ServerSocket server = null;
		Socket sock = null;
		System.out.println("EchoServer Started...");
		// 1��1�� �޽��� �ְ� ����.
		
		server = new ServerSocket(port);
		sock = server.accept();
		System.out.println(sock.getInetAddress()+"���� ����");
		// client�� �����ϸ� ���� ������ �λ縻�� �ǳٴ�. "�ȳ��ϼ��� ~��"
		OutputStream os = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		
		pw.println("�ȳ��ϼ���? "+sock.getInetAddress()+"��");
		
		// client�� �������� �޽����� ��� ��Ʈ�� ���
    	
		InputStream is = sock.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String msg = "";
		
		while ((msg = br.readLine()) != null) {
			if(msg.startsWith("�ȳ�")||msg.startsWith("����")) {
				pw.println("�ݰ�����~");
			}else if(msg.startsWith("��¥")) {
				pw.println(today);
			}else {
				pw.println(sock.getInetAddress()+"�� � ��!!");
			}
		}
		
		br.close();
		isr.close();
		is.close();
		pw.close();
		os.close();
		sock.close();
	}
}