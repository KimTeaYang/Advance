package io.day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

/* ObjectOutputStream / ObjectInputStream
 *  - 1byte ��� ��Ʈ��
 *  - Filter Stream
 *  - ��� : ����ȭ(Serializable)�� ������ ��ü�� ���Ϸ� �����ϰų�,
 *  	��Ʈ��ũ�� ������ �� �ִ�.
 *  - DataInput / DataOutput �������̽��� �����ϰ� ����
 *  - writeObject(Object obj) : ��ü�� ����Ʈ ������ �����ؼ� ������
 *  	��, ����ȭ�� ������ ��ü�� ������ �� �ִ�.
 * */
public class OOStream {
	
	public static void main(String[] args) 
	throws IOException, ClassNotFoundException {
		Emp e1 = new Emp("SCOTT",3000,20);
		Emp e2 = new Emp("James",2500,30);
		Emp e3 = new Emp("King",5000,10);
		
		FileOutputStream fos
			= new FileOutputStream("obj.txt");
		
		ObjectOutputStream oos
			= new ObjectOutputStream(fos);
		
		oos.writeObject(e1);
		oos.writeObject(e2);
		oos.writeObject(e3);
		
		JFrame f = new JFrame("��ü ��Ʈ��");
		f.getContentPane().add(new JButton("Hi"),"Center");
		
		oos.writeObject(f);
		
		Date d = new Date();
		oos.writeObject(d);
		
		oos.flush();
		oos.close();
		fos.close();
		System.out.println("obj.txt���� �Ϸ�");
		
	}
	
}