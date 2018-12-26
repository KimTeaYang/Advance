package io.day03;

import java.io.*;

/* BufferedReader / BufferedWriter
 *  - 2byte���
 *  - ���� ��Ʈ��
 *  - ���Ϳ� ��� �а� ����.
 *  - ���� ������ �о���̴� ����� ���´�.
 * */

public class StandardInOut2 {

	public static void main(String[] args) 
	throws Exception {
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		
		OutputStreamWriter ow = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(ow);
		
		bw.write("�Է��ϼ���=>");
		bw.flush();
		String line = "";
		
		while((line=br.readLine())!=null) {
			bw.write(line);
			bw.newLine(); // �ٹٲ�ó��
			bw.flush();
		}
		
		bw.close();
		ow.close();
		br.close();
		ir.close();
	}

}
