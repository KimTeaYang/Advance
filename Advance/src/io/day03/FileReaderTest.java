package io.day03;

import java.io.*;

/* FileReader / FileWriter
 *  - 2byte(문자)기반 스트림
 *  - 노드 스트림(파일과 노드 연결)
 *  [실습] 파일을 읽어서 파일로 내보내자(카피)
 * */

public class FileReaderTest {

	public static void main(String[] args) 
	throws IOException {
		String fileName = "C:\\Users\\1class-18\\Desktop\\Advance배포\\IO개요.java";
		
		File file = new File(fileName);
		
		System.out.println("원본 파일 크기: "+file.length()+"bytes");
		
		FileReader fr = new FileReader(file);
		FileWriter fw = new FileWriter("copy2.txt");
		PrintWriter pw = new PrintWriter(System.out);
		
		int n=0, total=0;
		char[] c= new char[1000];
		
		while((n=fr.read(c))!=-1) {
			fw.write(c, 0, n);
			fw.flush();
			pw.write(c, 0, n);
			pw.flush();
			total+=n;
		}
		System.out.println("total="+total);
		System.out.println("copy.txt로 카피완료");
		fr.close();
		fw.close();
		pw.close();
		
		
	}
}