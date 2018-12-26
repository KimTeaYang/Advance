package io.day03;

import java.io.*;

public class BufferedReaderTest {

	public static void main(String[] args)
	throws Exception {
		String fileName="C:\\myjava\\오라클SQL배포\\00오라클SQL_PL_SQL.docx";
		File file = new File(fileName);
		
		FileInputStream fis = new FileInputStream(file);
		
		FileOutputStream fos = new FileOutputStream("test11.docx");
		
		int n=0;
		byte[] data = new byte[400];
		
		while((n=fis.read(data))!=-1) {
			fos.write(data,0,n);
			fos.flush();
		}
		
		System.out.println("copy suc!");
		
		fos.close();
		fis.close();
	}
}
