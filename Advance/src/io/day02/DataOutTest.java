package io.day02;

import java.io.*;
/* DataOutputStream / DataInputStream
 *  - 1byte 기반 스트림
 *  - 필터 스트림
 *  - 기능 : 자바의 다양한 자료형들을 바이트 단위로 분해하여 쓰고, 
 *  		이를 다시 자료형별로 복원하여 읽는 기능을 수행함.
 *  - [주의] DataInputStream과 DataOutputStream은 서로 짝을 이뤄 사용.
 *  - [실습] data.text파일에 자바의 다양한 자료형 데이터를 써보자.
 *		목적지 : data.text(파일)=> FileOutputStream=>DataOutputStream
 *
 * */

public class DataOutTest {

	public static void main(String[] args) 
	throws Exception {
		// 1. 노드 연결
		FileOutputStream fos
			= new FileOutputStream("data.txt");
		// 2. 필터링
		DataOutputStream dos
			= new DataOutputStream(fos);
		
		// 3. 자바의 다양한 자료형의 데이터를 써보자.
		byte a = 127; // 1byte
		byte[] ba = {65,66,67}; // 3byte
		short s = 3000; // 2byte
		char ch = '가'; // 2byte
		boolean bool = true; // 1byte
		String str = "홍길동"; // 9byte + (UTF-8방식)2byte
		
		dos.writeByte(a);
		dos.write(ba);
		dos.writeShort(s);
		dos.writeChar(ch);
		dos.writeBoolean(bool);
		dos.writeUTF(str);
		/*  유니코드 UTF-8형식으로 문자열을 출력하는 메소드 UTF-8형식은 각 문자의
		 * 표현을 위해 1byte 사용했는지, 2byte 또는 3byte 차지하는지 알아내어
		 * 아스키 문자는 1byte로 그리스어,히브리어,아랍어 등의 문자는 2byte로
		 * 그 외 문자는 3바이트로 표현한다. 
		 * */
		
		System.out.println("총 "+dos.size()+"byte");
		dos.flush();
		dos.close();
		
		System.out.println("data.txt파일을 다시 읽고 복원합시다.");
		
		DataInputStream dis
			= new DataInputStream(new FileInputStream("data.txt"));
		// 읽을 때는 쓴 순서대로 자료형에 맞춰 읽자.
		
		System.out.println("읽을 수 있는 byte: "+dis.available());
		
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