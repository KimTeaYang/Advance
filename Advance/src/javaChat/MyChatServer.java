package javaChat;

import java.io.*;
import java.net.*;
import java.util.*;
/* 특정 포트로 클라이언트 연결을 무한정 기다린다.
 * 클과 연결이 이뤄지면 클과 통신을 담당할 스레드(chatHandler)를 생성한 후,
 * 스레드를 동작시킨다.
 * 또한 여러 명의 클라이언트와 통신하기 위해 ChatHandler를 Vector에 저장하여
 * 관리한다.
 * */

public class MyChatServer extends Thread {
	
	private ServerSocket server;
	private final int port = 33333;
	Vector<ChatHandler> userV = new Vector<>(5,3);

	public MyChatServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("##채팅 서버가 시작됐어요####");
			System.out.println("##["+port+"]번 포트에서 대기중##");
		} catch (IOException e) {
			System.out.println("##챗서버 시작 중 예외: "+e+"##");
			return;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println(
						"["+sock.getInetAddress()+"]클이 접속했어요");
				//클과 통신을 담당할 ChatHandler스레드 생성하고 동작
				ChatHandler chat = new ChatHandler(sock,userV);
				
				chat.start();
				
			}catch (IOException e) {
				System.out.println("##클의 소켓 생성 실패: "+e);
			}
		}
	}

	public static void main(String[] args) {
		new MyChatServer().start();
	}

}