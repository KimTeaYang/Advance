package io.day01;

import java.io.*;
import javax.swing.*;
/* FileInputStream
 *  - 1byte ��� ��Ʈ��
 *  - Node Stream : ���ϰ� ��� ������ �Ѵ�.
 *  - ������ �о���̴� ��Ʈ��
 *  
 *  [�ǽ�] InputStreamTest.java ������ �о ���� �ֿܼ� ����غ���.
 *   ������ �ҽ�   : ���� (FileInputStream)
 *   ������ ������ : �ܼ� (System.out)
 * */

public class FileInStream {

	public static void main(String[] args) {
		String file 
			= JOptionPane.showInputDialog(
					"���� ���ϸ��� �Է��ϼ���",
					"./src/io/day01/InputStreamTest.java");
		// Advance ������Ʈ => ���ذ��
		
		try {
			//���ϰ� ��� ����
			FileInputStream fis = new FileInputStream(file);
			PrintStream ps = System.out; // �ְܼ� ��忬��
			
			int n=0, count=0;
			while((n=fis.read())!=-1) {
				//������ ���� ������ -1�� ��ȯ�Ѵ�.
				ps.write(n);
				count++;
			}
			ps.println("�� "+count+"byte");
			
			fis.close();
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}