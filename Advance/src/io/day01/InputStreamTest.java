package io.day01;

import java.io.*;

/* System.in : InputStream 타입
 *  - 1 byte 기반 스트림
 *  - Node 스트림 : 키보드와 노드 연결하는 스트림
 *  - public int read() : byte 입력을 반환하고 입력이 
 *  	종료(Ctrl+C 또는 Ctrl+D)되면 -1을 반환한다.
 *  
 * */

public class InputStreamTest {

	public static void main(String[] args) 
	throws IOException {
		int input=0, count=0;
		System.out.println("입력하세요=>");
		while(true) {
			input = System.in.read();
			System.out.println("input= "+input);
			count++;
			if(input=='x') break;
		}
		System.out.println("-------------------");
		System.out.println("총 "+count+"byte 읽음");
		System.out.println("-------------------");
		System.in.close();
		System.out.close();
	}

}
