package io.day01;

import java.io.*;
/* [�ǽ�] c:/MyJava/pic.png ������ �о
 * c:/MyJava/target.png ���Ϸ� ī���սô�.
 * 
 * ������ �ҽ� : FileInputStream
 * ������ ������ : FileOutputStream
 * */

import javax.swing.JOptionPane;

public class ImageCopy {

	public static void main(String[] args) 
	throws IOException {
		String file 
		= JOptionPane.showInputDialog(
				"���� ���ϸ��� �Է��ϼ���", "c:/MyJava/pic.png");
		
		byte[] data = new byte[542];
		int n=0, total=0;
		
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos 
			= new FileOutputStream("c:/MyJava/target.png");
		
		while((n=fis.read(data))!=-1) {
			fos.write(data,0,n);
			fos.flush(); 
			total+=n;
		}
		System.out.println("�� "+total+"byte");
		fos.close();
		fis.close();
	}
}