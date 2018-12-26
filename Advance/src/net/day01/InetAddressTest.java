package net.day01;

import java.net.*;

/* InetAddress Ŭ����
 *  - IP �ּҸ� �߻�ȭ�� Ŭ����
 *  - ��ü ������ new�ؼ� �ϴ� ���� �ƴ϶� static�޼ҵ带 ���� ����.
 *    public static InetAddress getByName("ȣ��Ʈ��")
 *    public static InetAddress[] getAllByName("ȣ��Ʈ��")
 * */

public class InetAddressTest {

	public static void main(String[] args) {
		try {
			InetAddress inet 
				= InetAddress.getByName("www.naver.com");
			System.out.println("ȣ��Ʈ��: "+inet.getHostName());
			System.out.println("ȣ��Ʈ�� IP�ּ�: "+inet.getHostAddress());
			
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
