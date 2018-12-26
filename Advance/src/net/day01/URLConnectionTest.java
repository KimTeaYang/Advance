package net.day01;

import java.net.*;
import java.io.*;
/* URLConnection 클래스
 *  - URL객체를 통해 얻어온다.
 *    openConnection()메소드를 이용
 *  - URL클래스는 원격 서버 자원의 결과만 얻어오지만,
 *    URLConnection은 자원 결과 뿐 아니라 헤더정보와 자원정보를 함께 얻을 수 있다. 
 * */

public class URLConnectionTest {

	public static void main(String[] args) 
	throws MalformedURLException, IOException {
		String str="https://s-i.huffpost.com/gen/3948866/thumbs/o-PEPE-THE-FROG-570.jpg?3";
		URL url = new URL(str);
		URLConnection urlCon = url.openConnection();
		
		urlCon.connect(); // 연결
		
		int fsize = urlCon.getContentLength();
		System.out.println("파일크기: "+fsize);
		
		String contentType
			= urlCon.getContentType();
		System.out.println("파일형식: "+contentType);
		
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