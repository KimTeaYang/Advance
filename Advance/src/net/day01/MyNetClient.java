package net.day01;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/* Ŭ���̾�Ʈ��
 *  [1] Socket�� �ʿ�
 * */
public class MyNetClient {

	public static void main(String[] args) 
	throws IOException {
		// ���� ����=> ������ IP�ּ�, ��Ʈ��ȣ
		String ip = "192.168.0.60";
		Socket sock = new Socket(ip,5555);
		// ������ ����Ǹ� Socket��ü�� �����ǰ�, ����ȵǸ� IOException �߻�
		System.out.println("������ �����");
		
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		System.out.println("From Server>> ����� ����: "+num);
		
		String msg = JOptionPane.showInputDialog(
				"�������� ���� �޽����� �Է��ϼ���.");
		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);
		
		dos.writeUTF(msg);
		dos.flush();
		
		dos.close();
		os.close();
		dis.close();
		is.close();
		sock.close();
	}

}
