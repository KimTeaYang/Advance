package net.day02;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/* 1��1 ä��
 *  - Ű����� �Է��� ������ C���� ������ ���ÿ� C�� �������� �޽����� ���� ��.
 *  - Ŭ�� �������� �޽����� ��� �ֿܼ� ����ϴ� �����带 �̿��غ���.
 * */

public class ChatServer extends Thread {
	
	ServerSocket server;
	Socket sock;
	BufferedReader key, in;
	PrintWriter pout;
	final int port = 9999;

	public ChatServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("ChatServer Started...");
			
			sock = server.accept();
			System.out.println("##Client�� �����ؿ�##");
			
			String cip = sock.getInetAddress().getHostAddress();
			System.out.println(cip);
			
			// Client�� ����� ��Ʈ��
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			pout = new PrintWriter(sock.getOutputStream(),true);
			// Ű���� �Է� ��Ʈ��
			key = new BufferedReader(
					new InputStreamReader(System.in));
			
			this.start();
			
			// Ű���� �Է��ؼ� Client���� �޽��� ����
			String myMsg="";
			while((myMsg=key.readLine())!=null) {
				pout.println(myMsg);
			}
			
		} catch (IOException e) {
			System.out.println("IO����: "+e.getMessage());
		}
	}
	
	
	// Client�� �������� �޽����� ��ӵ�� �ֿܼ� ���
	@Override
	public void run() {
		String cMsg="";
		try {
			while((cMsg=in.readLine())!=null) {
				System.out.println("From Client>> "+cMsg);
			}
		} catch (IOException e) {
			System.out.println("##Client�� ������ �������ϴ�.");
			System.out.println(e.getMessage());
			
			try {
				in.close();
				pout.close();
				key.close();
				sock.close();
			} catch (Exception ex) {
				
			}
			
		}
	}

	public static void main(String[] args) {
		new ChatServer();
	}

}
