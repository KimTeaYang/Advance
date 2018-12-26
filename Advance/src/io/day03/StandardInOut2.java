package io.day03;

import java.io.*;

/* BufferedReader / BufferedWriter
 *  - 2byte기반
 *  - 필터 스트림
 *  - 버터에 모아 읽고 쓴다.
 *  - 라인 단위로 읽어들이는 기능을 갖는다.
 * */

public class StandardInOut2 {

	public static void main(String[] args) 
	throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(ow);
		
		bw.write("입력하세요=>");
		bw.flush();
		String line = "";
		
		while((line=br.readLine())!=null) {
			bw.write(line);
			bw.newLine(); // 줄바꿈처리
			bw.flush();
		}
		
		bw.close();
		ow.close();
		br.close();
		ir.close();
	}

}
