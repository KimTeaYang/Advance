package io.day01;

import java.io.*;
/* �����͸� 1byte ������ �̵���Ű�� ���� �ƴ϶� �迭�� ��Ƽ� �̵���Ű��.
 *  - ������ �ҽ� : Ű���� => System.in
 *  - ������ ������ : �ܼ� => System.out
 * */
public class InputStreamTest3 {

	public static void main(String[] args) 
	throws IOException {
		int n=0, count=0, total=0;
		byte[] data = new byte[6];
		
		while((n=System.in.read(data))!=-1) {
			// �Է¹��� �����ʹ� �迭�� ����.
			// n : �ް��ǿ� ��� �ް� ���� (���� ����Ʈ ��)
			System.out.write(data,0,n);
			count++; // �ݺ��� Ƚ��
			total+=n;
		}
		System.out.println("�� "+total+"byte �Է¹���");
		
		System.in.close();
		System.out.close();
	}
}