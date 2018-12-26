package io.day02;

import java.io.*;
/* BufferedInputStream/BufferedOutputStream
 *  - 1byte 기반 스트림
 *  - Filter 스트림
 *  - 바이트 단위로 들어오는 데이터를 버퍼에 차곡 차곡 모아서 읽어들인다.
 *    데이터는 버퍼가 누적되고 버퍼가 가득 차면 한꺼번에 읽어들인다.
 *    기본 버퍼 크기 : 512bytes
 *  - [주의] 필터 스트림은 데이터소스나 목적지에 직접 연결하지 못함
 *  
 *  - [실습] 키보드로 입력받아 도스 콘솔에 출력하고
 *          파일로도 출력하세요
 * */
public class BIStream {

	public static void main(String[] args) 
	throws IOException {
		
		InputStream is = System.in;
		PrintStream ps = System.out;
		
		FileOutputStream fos 
		= new FileOutputStream("c:/myjava/result3.txt");
		
		BufferedInputStream bis 
			= new BufferedInputStream(is);
		
		BufferedOutputStream bos
			= new BufferedOutputStream(ps);
		
		
		BufferedOutputStream bos2
			= new BufferedOutputStream(fos);
		
		ps.println("입력하세요=>");
		
		int n=0,total=0;
		
		while((n=bis.read())!=-1) {
			bos.write(n);
			bos.flush();
			bos2.write(n);
			bos2.flush();
			total++;
		}
		ps.println(total+"bytes");
		
		bos2.close();
		bos.close();
		bis.close();
		ps.close();
		is.close();
	}

}
