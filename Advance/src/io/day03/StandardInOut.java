package io.day03;

import java.io.*;
/* InputStreamReader / OutputStreamWriter
 *  - 2byte 기반 스트림
 *  - Bridge 스트림
 *  - 1byte 스트림과 2byte필터 스트림 사이의 가교 역할을 한다.
 *  - 1byte로 입력받은 내용을 2byte로 조합하여 읽어들인다.
 *  - [실습] 키보드 입력받아 콘솔에 출력하자
 * */

public class StandardInOut {

	public static void main(String[] args) 
	throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		
		ow.write("입력하세요=>");
		ow.flush();
		
		int n=0,total=0;
		char[] c = new char[256];
		
		while((n=ir.read(c))!=-1) {
			ow.write(c, 0, n);
			ow.flush();
			total+=n;
		}
		
		System.out.println(total);
		
		ow.close();
		ir.close();
	}

}
