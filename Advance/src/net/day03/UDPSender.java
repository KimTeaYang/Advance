package net.day03;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

/* UDP방식으로 서버에 데이터를 보낸다.
 *  - TCP : 연결 지향형. 신뢰적. 패킷 정렬을 함. 연결하는데 시간이 걸림
 *   (패킷이 무분별하게 도착하면 패킷을 순서대로 정리함) 
 *   Socket을 사용 ex) 전화
 *   
 *  - UDP : 비연결 지향형. 비신뢰적. 순서대로 도착한다는 보장을 못함.
 *   TCP에 비해 빠르게 전달됨. ex) 소포(우편배달)
 *   DatagramPacket, DatagramSocket을 사용
 *   TCP처럼 스트림 통신이 아니라, 데이터그램을 통해 통신한다.
 *   [1] DatagramPacket : 수신을 위한 생성자와 송신을 위한 생성자 2가지기 제공됨.
 *    주고받는 데이터와 관련된 클래스
 *   [2] DatagramSocket : 데이터 전송과 관련된 클래스. 송수신 모두 관련됨.
 *   
 * [실습] 키보드로 메시지 입력하여 UDP방식으로 서버에 데이터를 전송해보자.
 * */
public class UDPSender {

	public static void main(String[] args) throws IOException {
		String ipStr = JOptionPane.showInputDialog(
				"상대방 IP주소를 입력하세요.");
		if(ipStr==null) return;
		
		InetAddress inet = InetAddress.getByName(ipStr);
		
		BufferedReader key = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("보낼 내용을 입력하세요=>");
		String msg="";
		DatagramSocket ds = new DatagramSocket(); //우편 배달원
		
		while((msg=key.readLine())!=null) {
			if(msg.equalsIgnoreCase("x")) break;
			byte[] data = msg.getBytes();
			
			// 소포로 포장 - 보내는쪽, data와 상대방 ip, 포트번호
			DatagramPacket pack = new DatagramPacket(
					data, data.length, inet, 3000);
			ds.send(pack);
			System.out.println("보낼 내용을 입력하세요=>");
		}
		ds.close();
		key.close();
	}
	
}