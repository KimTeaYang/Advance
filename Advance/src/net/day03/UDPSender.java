package net.day03;

import java.net.*;

import javax.swing.JOptionPane;

import java.io.*;

/* UDP������� ������ �����͸� ������.
 *  - TCP : ���� ������. �ŷ���. ��Ŷ ������ ��. �����ϴµ� �ð��� �ɸ�
 *   (��Ŷ�� ���к��ϰ� �����ϸ� ��Ŷ�� ������� ������) 
 *   Socket�� ��� ex) ��ȭ
 *   
 *  - UDP : �񿬰� ������. ��ŷ���. ������� �����Ѵٴ� ������ ����.
 *   TCP�� ���� ������ ���޵�. ex) ����(������)
 *   DatagramPacket, DatagramSocket�� ���
 *   TCPó�� ��Ʈ�� ����� �ƴ϶�, �����ͱ׷��� ���� ����Ѵ�.
 *   [1] DatagramPacket : ������ ���� �����ڿ� �۽��� ���� ������ 2������ ������.
 *    �ְ�޴� �����Ϳ� ���õ� Ŭ����
 *   [2] DatagramSocket : ������ ���۰� ���õ� Ŭ����. �ۼ��� ��� ���õ�.
 *   
 * [�ǽ�] Ű����� �޽��� �Է��Ͽ� UDP������� ������ �����͸� �����غ���.
 * */
public class UDPSender {

	public static void main(String[] args) throws IOException {
		String ipStr = JOptionPane.showInputDialog(
				"���� IP�ּҸ� �Է��ϼ���.");
		if(ipStr==null) return;
		
		InetAddress inet = InetAddress.getByName(ipStr);
		
		BufferedReader key = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("���� ������ �Է��ϼ���=>");
		String msg="";
		DatagramSocket ds = new DatagramSocket(); //���� ��޿�
		
		while((msg=key.readLine())!=null) {
			if(msg.equalsIgnoreCase("x")) break;
			byte[] data = msg.getBytes();
			
			// ������ ���� - ��������, data�� ���� ip, ��Ʈ��ȣ
			DatagramPacket pack = new DatagramPacket(
					data, data.length, inet, 3000);
			ds.send(pack);
			System.out.println("���� ������ �Է��ϼ���=>");
		}
		ds.close();
		key.close();
	}
	
}