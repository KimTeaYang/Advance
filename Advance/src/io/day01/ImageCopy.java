package io.day01;

import java.io.*;
/* [실습] c:/MyJava/pic.png 파일을 읽어서
 * c:/MyJava/target.png 파일로 카피합시다.
 * 
 * 데이터 소스 : FileInputStream
 * 데이터 목적지 : FileOutputStream
 * */

import javax.swing.JOptionPane;

public class ImageCopy {

	public static void main(String[] args) 
	throws IOException {
		String file 
		= JOptionPane.showInputDialog(
				"읽을 파일명을 입력하세요", "c:/MyJava/pic.png");
		
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
		System.out.println("총 "+total+"byte");
		fos.close();
		fis.close();
	}
}