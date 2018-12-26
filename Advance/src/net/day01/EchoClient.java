package net.day01;

import java.net.*;
import java.io.*;
import javax.swing.*;
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
public class EchoClient {

	public static void main(String[] args) 
	throws UnknownHostException, IOException {
		String ip = JOptionPane.showInputDialog(
				"접속할 서버의 IP주소를 입력하세요.");
				
		Socket sock = new Socket(ip,7777);
		System.out.println("서버와 연결됨!");
		
		InputStream is = sock.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String serverMsg = br.readLine();
		System.out.println(serverMsg);
    	
    	BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);
		
		String msg="";
		while((msg=key.readLine())!=null) { // 키보드 입력
			pw.println(msg); // 서버로 전송
			System.out.println("From Server>> "+br.readLine());
		}
		
		pw.close();
		key.close();
		br.close();
		isr.close();
		is.close();
		sock.close();
	}

}
