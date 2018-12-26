package io.day03;

import java.io.*;

/* FileReader / FileWriter
 *  - 2byte(����)��� ��Ʈ��
 *  - ��� ��Ʈ��(���ϰ� ��� ����)
 *  [�ǽ�] ������ �о ���Ϸ� ��������(ī��)
 * */

public class FileReaderTest {

	public static void main(String[] args) 
	throws IOException {
		String fileName = "C:\\Users\\1class-18\\Desktop\\Advance����\\IO����.java";
		
		File file = new File(fileName);
		
		System.out.println("���� ���� ũ��: "+file.length()+"bytes");
		
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
		System.out.println("copy.txt�� ī�ǿϷ�");
		fr.close();
		fw.close();
		pw.close();
		
		
	}
}