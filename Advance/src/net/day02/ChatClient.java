package net.day02;

import java.net.*;
import javax.swing.JOptionPane;
import java.io.*;

public class ChatClient implements Runnable {
	
	Socket sock;
	BufferedReader in, key;
	PrintWriter pout;
	final int port = 9999;

	public ChatClient(String ip) {
		try {
			sock = new Socket(ip, port);
			System.out.println("서버와 연결됨!");
			
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			pout = new PrintWriter(sock.getOutputStream(),true);
			
			key = new BufferedReader(
					new InputStreamReader(System.in));
			
			Thread tr = new Thread(this);
			tr.start();
			
			String cMsg="";
			while((cMsg=key.readLine())!=null) {
				pout.println(cMsg);
			}
			
		} catch (UnknownHostException e) {
			System.out.println("없는 Host입니다: "+e.getMessage());
		} catch (IOException e) {
			System.out.println("IO오류: "+e.getMessage());
		}
	}
	
	@Override
	public void run() {
		String sMsg="";
		try {
			while((sMsg=in.readLine())!=null) {
				System.out.println("From Server>> "+sMsg);
			}
		} catch (IOException e) {
			System.out.println("##Server가 연결을 끊었습니다.");
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
		String ip = JOptionPane.showInputDialog(
				"접속할 서버의 ip를 입력하세요.");
		if(ip==null||ip.trim().isEmpty()) {
			ip = "localhost";
		}
		new ChatClient(ip);
	}

}
