package net.day03;

import java.net.*;
import java.io.*;
/* 데이터를 수신하는 측 */
public class UDPServer {
	
	public static void main(String[] args) throws Exception{
		byte[] buffer = new byte[100];
		// UDP의 실제 데이터는 512바이트로 제한하는 경우가 많다.
		
		DatagramSocket ds = new DatagramSocket(3000);
		// 수신하는 쪽 패킷 => ip, port는 필요없다.
		DatagramPacket pack = new DatagramPacket(
				buffer, buffer.length);
		while(true) {
			ds.receive(pack);
			byte[] bmsg = pack.getData();
			String msg = new String(bmsg,0,pack.getLength());
			System.out.println(pack.getAddress()+"로 부터온 메시지");
			System.out.println(msg);
		}
	}
}