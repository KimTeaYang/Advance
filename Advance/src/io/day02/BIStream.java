package io.day02;

import java.io.*;
/* BufferedInputStream/BufferedOutputStream
 *  - 1byte ��� ��Ʈ��
 *  - Filter ��Ʈ��
 *  - ����Ʈ ������ ������ �����͸� ���ۿ� ���� ���� ��Ƽ� �о���δ�.
 *    �����ʹ� ���۰� �����ǰ� ���۰� ���� ���� �Ѳ����� �о���δ�.
 *    �⺻ ���� ũ�� : 512bytes
 *  - [����] ���� ��Ʈ���� �����ͼҽ��� �������� ���� �������� ����
 *  
 *  - [�ǽ�] Ű����� �Է¹޾� ���� �ֿܼ� ����ϰ�
 *          ���Ϸε� ����ϼ���
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
		
		ps.println("�Է��ϼ���=>");
		
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
