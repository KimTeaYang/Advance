package net.day01;

import java.net.*;

/* InetAddress 클래스
 *  - IP 주소를 추상화한 클래스
 *  - 객체 생성을 new해서 하는 것이 아니라 static메소드를 통해 얻어옴.
 *    public static InetAddress getByName("호스트명")
 *    public static InetAddress[] getAllByName("호스트명")
 * */

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress inet 
				= InetAddress.getByName("www.naver.com");
			System.out.println("호스트명: "+inet.getHostName());
			System.out.println("호스트명 IP주소: "+inet.getHostAddress());
			
			InetAddress[] inets
				= InetAddress.getAllByName("www.daum.net");
			if(inets!=null) {
				for(InetAddress ia:inets) {
					System.out.println(ia.getHostName());
					System.out.println(ia.getHostAddress());
					System.out.println("================");
				}
			}
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
