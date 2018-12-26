package net.day02;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/* 1대1 채팅
 *  - 키보드로 입력한 내용을 C에게 보냄과 동시에 C가 보내오는 메시지를 들어야 함.
 *  - 클이 보내오는 메시지를 듣고 콘솔에 출력하는 스레드를 이용해보자.
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
			System.out.println("##Client가 접속해옴##");
			
			String cip = sock.getInetAddress().getHostAddress();
			System.out.println(cip);
			
			// Client와 연결된 스트림
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			pout = new PrintWriter(sock.getOutputStream(),true);
			// 키보드 입력 스트림
			key = new BufferedReader(
					new InputStreamReader(System.in));
			
			this.start();
			
			// 키보드 입력해서 Client에게 메시지 전송
			String myMsg="";
			while((myMsg=key.readLine())!=null) {
				pout.println(myMsg);
			}
			
		} catch (IOException e) {
			System.out.println("IO오류: "+e.getMessage());
		}
	}
	
	
	// Client가 보내오는 메시지를 계속듣고 콘솔에 출력
	@Override
	public void run() {
		String cMsg="";
		try {
			while((cMsg=in.readLine())!=null) {
				System.out.println("From Client>> "+cMsg);
			}
		} catch (IOException e) {
			System.out.println("##Client가 연결을 끊었습니다.");
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
