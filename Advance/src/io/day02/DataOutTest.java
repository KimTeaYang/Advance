package io.day02;

import java.io.*;
/* DataOutputStream / DataInputStream
 *  - 1byte ��� ��Ʈ��
 *  - ���� ��Ʈ��
 *  - ��� : �ڹ��� �پ��� �ڷ������� ����Ʈ ������ �����Ͽ� ����, 
 *  		�̸� �ٽ� �ڷ������� �����Ͽ� �д� ����� ������.
 *  - [����] DataInputStream�� DataOutputStream�� ���� ¦�� �̷� ���.
 *  - [�ǽ�] data.text���Ͽ� �ڹ��� �پ��� �ڷ��� �����͸� �Ẹ��.
 *		������ : data.text(����)=> FileOutputStream=>DataOutputStream
 *
 * */

public class DataOutTest {

	public static void main(String[] args) 
	throws Exception {
		// 1. ��� ����
		FileOutputStream fos
			= new FileOutputStream("data.txt");
		// 2. ���͸�
		DataOutputStream dos
			= new DataOutputStream(fos);
		
		// 3. �ڹ��� �پ��� �ڷ����� �����͸� �Ẹ��.
		byte a = 127; // 1byte
		byte[] ba = {65,66,67}; // 3byte
		short s = 3000; // 2byte
		char ch = '��'; // 2byte
		boolean bool = true; // 1byte
		String str = "ȫ�浿"; // 9byte + (UTF-8���)2byte
		
		dos.writeByte(a);
		dos.write(ba);
		dos.writeShort(s);
		dos.writeChar(ch);
		dos.writeBoolean(bool);
		dos.writeUTF(str);
		/*  �����ڵ� UTF-8�������� ���ڿ��� ����ϴ� �޼ҵ� UTF-8������ �� ������
		 * ǥ���� ���� 1byte ����ߴ���, 2byte �Ǵ� 3byte �����ϴ��� �˾Ƴ���
		 * �ƽ�Ű ���ڴ� 1byte�� �׸�����,���긮��,�ƶ��� ���� ���ڴ� 2byte��
		 * �� �� ���ڴ� 3����Ʈ�� ǥ���Ѵ�. 
		 * */
		
		System.out.println("�� "+dos.size()+"byte");
		dos.flush();
		dos.close();
		
		System.out.println("data.txt������ �ٽ� �а� �����սô�.");
		
		DataInputStream dis
			= new DataInputStream(new FileInputStream("data.txt"));
		// ���� ���� �� ������� �ڷ����� ���� ����.
		
		System.out.println("���� �� �ִ� byte: "+dis.available());
		
		int x = dis.readByte();
		System.out.println(x);
		
		byte[] buf = new byte[3];
		int n = dis.read(buf);
		
		for(byte bt:buf) {
			System.out.println(bt);
		}
		
		short st = dis.readShort();
		System.out.println(st);
		
		char c = dis.readChar();
		System.out.println(c);
		
		boolean bl = dis.readBoolean();
		System.out.println(bl);
		
		String str1 = dis.readUTF();
		System.out.println(str1);
		
		dis.close();
	}
}