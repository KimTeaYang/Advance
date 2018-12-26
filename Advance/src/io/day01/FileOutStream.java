package io.day01;

import java.io.*;
/* [�ǽ�] Ű����� �Է¹��� ������ ����(result.txt)�� �����մϴ�.
 * 
 * ������ �ҽ�   : Ű���� (System.in)
 * ������ ������ : ���� (FileOutputStream)
 * */

public class FileOutStream {

	public static void main(String[] args)
	throws IOException {
		System.out.println("�Է��ϼ���=>"
				+ "[�� ������ c:/Myjava/result.txt�� ����˴ϴ�]");
		
		FileOutputStream fos 
			= new FileOutputStream("c:/Myjava/result.txt", true);
		//true���� �ָ� append(�����̱�) ���
		
		byte[] data = new byte[10];
		
		int n=0, total=0;
		while((n=System.in.read(data))!=-1) {
			fos.write(data);
			
			// ��Ʈ���� �����ִ� �����Ͱ� ������ ��� �������⸦ ����
			fos.flush(); 
			
			total+=n;
		}
		System.out.println("�� "+total+"byte");
		
		System.in.close();
		fos.close();
	}
	
}