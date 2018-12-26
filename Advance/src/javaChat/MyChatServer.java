package javaChat;

import java.io.*;
import java.net.*;
import java.util.*;
/* Ư�� ��Ʈ�� Ŭ���̾�Ʈ ������ ������ ��ٸ���.
 * Ŭ�� ������ �̷����� Ŭ�� ����� ����� ������(chatHandler)�� ������ ��,
 * �����带 ���۽�Ų��.
 * ���� ���� ���� Ŭ���̾�Ʈ�� ����ϱ� ���� ChatHandler�� Vector�� �����Ͽ�
 * �����Ѵ�.
 * */

public class MyChatServer extends Thread {
	
	private ServerSocket server;
	private final int port = 33333;
	Vector<ChatHandler> userV = new Vector<>(5,3);

	public MyChatServer() {
		try {
			server = new ServerSocket(port);
			System.out.println("##ä�� ������ ���۵ƾ��####");
			System.out.println("##["+port+"]�� ��Ʈ���� �����##");
		} catch (IOException e) {
			System.out.println("##ê���� ���� �� ����: "+e+"##");
			return;
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Socket sock = server.accept();
				System.out.println(
						"["+sock.getInetAddress()+"]Ŭ�� �����߾��");
				//Ŭ�� ����� ����� ChatHandler������ �����ϰ� ����
				ChatHandler chat = new ChatHandler(sock,userV);
				
				chat.start();
				
			}catch (IOException e) {
				System.out.println("##Ŭ�� ���� ���� ����: "+e);
			}
		}
	}

	public static void main(String[] args) {
		new MyChatServer().start();
	}

}