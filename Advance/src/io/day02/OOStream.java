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
 *  - 1byte 기반 스트림
 *  - Filter Stream
 *  - 기능 : 직렬화(Serializable)가 구현된 객체를 파일로 저장하거나,
 *  	네트워크로 전송할 수 있다.
 *  - DataInput / DataOutput 인터페이스를 구현하고 있음
 *  - writeObject(Object obj) : 객체를 바이트 단위로 분해해서 내보냄
 *  	단, 직렬화가 구현된 객체만 내보낼 수 있다.
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
		
		JFrame f = new JFrame("객체 스트림");
		f.getContentPane().add(new JButton("Hi"),"Center");
		
		oos.writeObject(f);
		
		Date d = new Date();
		oos.writeObject(d);
		
		oos.flush();
		oos.close();
		fos.close();
		System.out.println("obj.txt쓰기 완료");
		
	}
	
}