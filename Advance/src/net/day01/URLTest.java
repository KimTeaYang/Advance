package net.day01;

import java.net.*;
import java.io.*;

public class URLTest {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.hira.or.kr/re/diag/getDiagEvlList.do?pgmid=HIRAA030004000100#id01");
			// ��������://ȣ��Ʈ��:��Ʈ��ȣ/���/���ϸ�?�Ķ���͸�=��#ref
			
			// ftp://ftp.kaist.ac.kr/pub/
			// file:///c:\myjava\test.html
			
			String pro = url.getProtocol();
			System.out.println("��������: "+pro);
			System.out.println("Host: "+url.getHost());
			System.out.println("Port: "+url.getPort());
			System.out.println("dPort: "+url.getDefaultPort());
			System.out.println("file: "+url.getFile());
			System.out.println("Query: "+url.getQuery());
			System.out.println("Ref: "+url.getRef());
			/* ��Ʈ�� -1�� ��ȯ�ϴ� ���, �̴� ����Ʈ ��Ʈ�� ���� */
			
			InputStream is=url.openStream();
			/* openStream()�� �̿��ϸ� URL�� ��ġ�� ���� �ڵ����� ������
			 * �Ͼ��, �� ����� InputStream�� ��ȯ�Ѵ�. */
			
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
			// URL������ �ƴ� ��� ���� �߻�
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}