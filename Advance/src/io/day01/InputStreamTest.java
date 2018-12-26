package io.day01;

import java.io.*;

/* System.in : InputStream Ÿ��
 *  - 1 byte ��� ��Ʈ��
 *  - Node ��Ʈ�� : Ű����� ��� �����ϴ� ��Ʈ��
 *  - public int read() : byte �Է��� ��ȯ�ϰ� �Է��� 
 *  	����(Ctrl+C �Ǵ� Ctrl+D)�Ǹ� -1�� ��ȯ�Ѵ�.
 *  
 * */

public class InputStreamTest {

	public static void main(String[] args) 
	throws IOException {
		int input=0, count=0;
		System.out.println("�Է��ϼ���=>");
		while(true) {
			input = System.in.read();
			System.out.println("input= "+input);
			count++;
			if(input=='x') break;
		}
		System.out.println("-------------------");
		System.out.println("�� "+count+"byte ����");
		System.out.println("-------------------");
		System.in.close();
		System.out.close();
	}

}
