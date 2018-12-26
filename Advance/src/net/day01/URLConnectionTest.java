package net.day01;

import java.net.*;
import java.io.*;
/* URLConnection Ŭ����
 *  - URL��ü�� ���� ���´�.
 *    openConnection()�޼ҵ带 �̿�
 *  - URLŬ������ ���� ���� �ڿ��� ����� ��������,
 *    URLConnection�� �ڿ� ��� �� �ƴ϶� ��������� �ڿ������� �Բ� ���� �� �ִ�. 
 * */

public class URLConnectionTest {

	public static void main(String[] args) 
	throws MalformedURLException, IOException {
		String str="https://s-i.huffpost.com/gen/3948866/thumbs/o-PEPE-THE-FROG-570.jpg?3";
		URL url = new URL(str);
		URLConnection urlCon = url.openConnection();
		
		urlCon.connect(); // ����
		
		int fsize = urlCon.getContentLength();
		System.out.println("����ũ��: "+fsize);
		
		String contentType
			= urlCon.getContentType();
		System.out.println("��������: "+contentType);
		
		InputStream is = urlCon.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(is);
		
		FileOutputStream fos = new FileOutputStream("test.jpeg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		int n = 0;
		byte[] data= new byte[4000];
		
		while((n=bis.read(data))!=-1) {
			bos.write(data,0,n);
			bos.flush();
		}
		
		bos.close();
		fos.close();
		bis.close();
		is.close();
	}

}