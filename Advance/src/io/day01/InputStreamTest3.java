package io.day01;

import java.io.*;
/* 데이터를 1byte 단위로 이동시키는 것이 아니라 배열에 담아서 이동시키자.
 *  - 데이터 소스 : 키보드 => System.in
 *  - 데이터 목적지 : 콘솔 => System.out
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException {
		int n=0, count=0, total=0;
		byte[] data = new byte[6];
		
		while((n=System.in.read(data))!=-1) {
			// 입력받은 데이터는 배열에 담긴다.
			// n : 달걀판에 담긴 달걀 갯수 (읽은 바이트 수)
			System.out.write(data,0,n);
			count++; // 반복문 횟수
			total+=n;
		}
		System.out.println("총 "+total+"byte 입력받음");
		
		System.in.close();
		System.out.close();
	}
}