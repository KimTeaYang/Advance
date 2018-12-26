package io.day03;

import java.io.*;
/* InputStreamReader / OutputStreamWriter
 *  - 2byte ��� ��Ʈ��
 *  - Bridge ��Ʈ��
 *  - 1byte ��Ʈ���� 2byte���� ��Ʈ�� ������ ���� ������ �Ѵ�.
 *  - 1byte�� �Է¹��� ������ 2byte�� �����Ͽ� �о���δ�.
 *  - [�ǽ�] Ű���� �Է¹޾� �ֿܼ� �������
 * */

public class StandardInOut {

	public static void main(String[] args) 
	throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		
		ow.write("�Է��ϼ���=>");
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
