package io.day01;

import java.io.*;
/* System.out : PrintStreamŸ��
 *  - 1 byte ��� ��Ʈ��
 *  - Node ��Ʈ�� : �ְܼ� ��� �����
 *  - print(), println()
 *  - public void write(int b)
 * */

public class InputStreamTest2 {

	public static void main(String[] args) 
	throws IOException {
		int n=0, count=0;
		
		//Ctrl+C�� ������ ������ ��� �Է� ����
		while((n=System.in.read())!=-1) {
			// System.out.print("input= "+n); // ascii�ڵ尪�� ���
			//System.out.print((char)n);
			System.out.write(n); // ascii�ڵ尪 ���
			count++;
		}
		System.out.println("�� "+count+"byte �Է¹���");
		System.in.close();
		System.out.close();
	}

}