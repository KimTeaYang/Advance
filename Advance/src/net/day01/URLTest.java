package net.day01;

import java.net.*;
import java.io.*;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.hira.or.kr/re/diag/getDiagEvlList.do?pgmid=HIRAA030004000100#id01");
			// 프로토콜://호스트명:포트번호/경로/파일명?파라미터명=값#ref
			
			// ftp://ftp.kaist.ac.kr/pub/
			// file:///c:\myjava\test.html
			
			String pro = url.getProtocol();
			System.out.println("프로토콜: "+pro);
			System.out.println("Host: "+url.getHost());
			System.out.println("Port: "+url.getPort());
			System.out.println("dPort: "+url.getDefaultPort());
			System.out.println("file: "+url.getFile());
			System.out.println("Query: "+url.getQuery());
			System.out.println("Ref: "+url.getRef());
			/* 포트가 -1을 반환하는 경우, 이는 디폴트 포트로 접속 */
			
			InputStream is=url.openStream();
			/* openStream()을 이용하면 URL이 위치한 곳과 자동으로 접속이
			 * 일어나고, 그 결과로 InputStream을 반환한다. */
			
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			String line="";
			String data="";
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			//System.out.println(data);
			
			br.close();
			isr.close();
			is.close();
		} catch (MalformedURLException e) {
			// URL형식이 아닐 경우 예외 발생
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}