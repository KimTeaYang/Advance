package net.day03;

import java.net.*;
import java.io.*;
/* �����͸� �����ϴ� �� */
public class UDPServer {
	
	public static void main(String[] args) throws Exception{
		byte[] buffer = new byte[100];
		// UDP�� ���� �����ʹ� 512����Ʈ�� �����ϴ� ��찡 ����.
		
		DatagramSocket ds = new DatagramSocket(3000);
		// �����ϴ� �� ��Ŷ => ip, port�� �ʿ����.
		DatagramPacket pack = new DatagramPacket(
				buffer, buffer.length);
		while(true) {
			ds.receive(pack);
			byte[] bmsg = pack.getData();
			String msg = new String(bmsg,0,pack.getLength());
			System.out.println(pack.getAddress()+"�� ���Ϳ� �޽���");
			System.out.println(msg);
		}
	}
}