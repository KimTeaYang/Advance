package io.day01;

import java.io.*;
/* [실습] 키보드로 입력받은 내용을 파일(result.txt)에 저장합니다.
 * 
 * 데이터 소스   : 키보드 (System.in)
 * 데이터 목적지 : 파일 (FileOutputStream)
 * */

public class FileOutStream {

	public static void main(String[] args)
	throws IOException {
		System.out.println("입력하세요=>"
				+ "[이 내용은 c:/Myjava/result.txt에 저장됩니다]");
		
		FileOutputStream fos 
			= new FileOutputStream("c:/Myjava/result.txt", true);
		//true값을 주면 append(덧붙이기) 기능
		
		byte[] data = new byte[10];
		
		int n=0, total=0;
		while((n=System.in.read(data))!=-1) {
			fos.write(data);
			
			// 스트림에 남아있는 데이터가 있으면 모두 내보내기를 해줌
			fos.flush(); 
			
			total+=n;
		}
		System.out.println("총 "+total+"byte");
		
		System.in.close();
		fos.close();
	}
	
}