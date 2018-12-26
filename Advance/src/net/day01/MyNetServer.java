package net.day01;

import java.net.*;
import java.io.*;
/* TCP통신 방식을 이용해 통신하는 프로그램을 작성합시다.
 *  - 서버단
 *   [1] ServerScocket
 *   [2] Socket
 *   두가지가 필요!
 * */

public class MyNetServer {

	public static void main(String[] args) 
	throws IOException {
		
		/* 0~1024는 예약된 포트. 1024이상 65535이하로 지정하는 것이 좋다. */
		final int port = 5555;
		
		// 1. 서버 소켓을 생성=> 포트번호 필요
		ServerSocket server = new ServerSocket(port);
		System.out.println("MyNetServer대기중...");			
		
		while(true) {
			Socket sock = server.accept();
			/* Client가 접속해서 들어오면 서버소켓은 Client와 연결된 소켓
			 * 객체를 반환해준다. */
			System.out.println("Client가 접속해옴");
			
			InetAddress ia = sock.getInetAddress();
			String cip = ia.getHostAddress();
			System.out.println("Client IP: "+cip);
			
			int num = (int)(Math.random()*100+1);
			
			OutputStream os = sock.getOutputStream();
			// client에게 숫자를 전송하기 위해 출력스트림(노드)을 얻는다.
			DataOutputStream dos = new DataOutputStream(os);
			// 자료 유형별로 필터링
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
