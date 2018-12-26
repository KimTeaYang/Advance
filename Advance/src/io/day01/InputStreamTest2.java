package io.day01;

import java.io.*;
/* System.out : PrintStream타입
 *  - 1 byte 기반 스트림
 *  - Node 스트림 : 콘솔과 노드 연결됨
 *  - print(), println()
 *  - public void write(int b)
 * */

public class InputStreamTest2 {

	public static void main(String[] args) 
	throws IOException {
		int n=0, count=0;
		
		//Ctrl+C를 누르기 전까지 계속 입력 받음
		while((n=System.in.read())!=-1) {
			// System.out.print("input= "+n); // ascii코드값을 출력
			//System.out.print((char)n);
			System.out.write(n); // ascii코드값 출력
			count++;
		}
		System.out.println("총 "+count+"byte 입력받음");
		System.in.close();
		System.out.close();
	}

}