package net.day01;

import java.net.*;
import java.io.*;
import javax.swing.*;
/*[������ ����]
 * - Client�� Server�� �����ϸ�
 * [1] ������ Ŭ���� "�ȳ��ϼ���? Ŭ���̾�Ʈ��~~"
 *    �̶� �޽����� ������.
 *    
 * [2] �׷��� Ŭ���̾�Ʈ�� Ű���� �Է��� ����
 *     �������� �޽����� ������.
 *     
 * [3] ������ Ŭ�� ������ �޽����� �м��ؼ�
 *     <1> "�ȳ��ϼ���?" �Ǵ� "����"�� �޽����� ����
 *       ==> "�ݰ�����~ Ŭ��!" �̶� �亯�ϰ�
 *     <2> "���� ��¥��" �̶� �޽����� ����
 *      ==> ���� ��¥�� �˷��ְ�
 *     <3> �� �� �ٸ� �޽����� ����
 *     ==> " ~�� � ��!!"�� �޽����� ������.   
 * */
public class EchoClient {

	public static void main(String[] args) 
	throws UnknownHostException, IOException {
		String ip = JOptionPane.showInputDialog(
				"������ ������ IP�ּҸ� �Է��ϼ���.");
				
		Socket sock = new Socket(ip,7777);
		System.out.println("������ �����!");
		
		InputStream is = sock.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		String serverMsg = br.readLine();
		System.out.println(serverMsg);
    	
    	BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(sock.getOutputStream(),true);
		
		String msg="";
		while((msg=key.readLine())!=null) { // Ű���� �Է�
			pw.println(msg); // ������ ����
			System.out.println("From Server>> "+br.readLine());
		}
		
		pw.close();
		key.close();
		br.close();
		isr.close();
		is.close();
		sock.close();
	}

}
