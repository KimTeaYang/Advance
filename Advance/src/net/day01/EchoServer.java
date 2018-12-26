package net.day01;

import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
/*[구현할 내용]
 * - Client가 Server에 접속하면
 * [1] 서버는 클에게 "안녕하세요? 클라이언트님~~"
 *    이란 메시지를 보낸다.
 *    
 * [2] 그러면 클라이언트는 키보드 입력을 통해
 *     서버에게 메시지를 보낸다.
 *     
 * [3] 서버는 클이 보내온 메시지를 분석해서
 *     <1> "안녕하세요?" 또는 "하이"란 메시지가 오면
 *       ==> "반가워요~ 클님!" 이라 답변하고
 *     <2> "오늘 날짜는" 이란 메시지가 오면
 *      ==> 오늘 날짜를 알려주고
 *     <3> 그 외 다른 메시지가 오면
 *     ==> " ~님 어여 가!!"란 메시지를 보내자.   
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
		// 1대1로 메시지 주고 받음.
		
		server = new ServerSocket(port);
		sock = server.accept();
		System.out.println(sock.getInetAddress()+"님이 접속");
		// client가 접속하면 먼저 서버가 인사말을 건넨다. "안녕하세요 ~님"
		OutputStream os = sock.getOutputStream();
		PrintWriter pw = new PrintWriter(os, true);
		
		pw.println("안녕하세요? "+sock.getInetAddress()+"님");
		
		// client가 보내오는 메시지를 듣는 스트림 얻기
    	
		InputStream is = sock.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String msg = "";
		
		while ((msg = br.readLine()) != null) {
			if(msg.startsWith("안녕")||msg.startsWith("하이")) {
				pw.println("반가워요~");
			}else if(msg.startsWith("날짜")) {
				pw.println(today);
			}else {
				pw.println(sock.getInetAddress()+"님 어여 가!!");
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