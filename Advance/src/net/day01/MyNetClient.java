package net.day01;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;
/* 클라이언트단
 *  [1] Socket만 필요
 * */
public class MyNetClient {

	public static void main(String[] args) 
	throws IOException {
		// 소켓 생성=> 서버의 IP주소, 포트번호
		String ip = "192.168.0.60";
		Socket sock = new Socket(ip,5555);
		// 서버와 연결되면 Socket객체가 생성되고, 연결안되면 IOException 발생
		System.out.println("서버와 연결됨");
		
		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		int num = dis.readInt();
		System.out.println("From Server>> 행운의 숫자: "+num);
		
		String msg = JOptionPane.showInputDialog(
				"서버에게 보낼 메시지를 입력하세요.");
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
