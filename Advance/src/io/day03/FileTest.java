package io.day03;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* public long length() : ����ũ��
 * public String getName() : ���ϸ�
 * public String getAbsolutePath() : ������
 * public String getPath() : �����
 * */

public class FileTest {

	public static void print(String str) {
		System.out.println(str);
	}
	
	public static void main(String[] args) {
		String str="src/images/������.png";
		File file = new File(str);
		
		print("���ϸ�: "+file.getName());
		print("����ũ��: "+file.length());
		print("������: "+file.getAbsolutePath());
		print ("�����: "+file.getPath());
		
		File dir = new File("sample","example");
		boolean b = dir.exists();
		if(!b) {
			boolean c = dir.mkdirs();
			print("���丮 ��������: "+c);
		}
		
		File dir2 = new File("study");
		if(!dir2.exists()) {
			dir2.mkdir();
		}
		
		
		System.out.println(dir2.renameTo(new File("simple")));
		System.out.println(dir2.delete());
		
		boolean isFile = file.isFile();
		print("���� ����: "+isFile);
		print("DIR ����: "+file.isDirectory()	);
		
		//������ ���������� ������ ��¥
		long time = file.lastModified();
		print("������ ������ ������: "+time);
		/* 1970�� 1��1�Ϻ��� ���������� ������ ��¥������ �ð��� �и������� �ʷ�
		 * ��ȯ�� */
		
		Date d = new Date(time);
		print(d.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(sdf.format(d));
	}

}