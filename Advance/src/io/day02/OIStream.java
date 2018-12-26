package io.day02;

import java.io.*;
import java.util.Date;

import javax.swing.JFrame;

public class OIStream {

	public static void main(String[] args) 
	throws Exception {
		FileInputStream fis
			= new FileInputStream("obj.txt");
	
		ObjectInputStream ois
			= new ObjectInputStream(fis);
		
		Emp e1 = (Emp) ois.readObject();
		e1.print();
		Emp e2 = (Emp) ois.readObject();
		e2.print();
		Emp e3 = (Emp) ois.readObject();
		e3.print();
		JFrame f = (JFrame) ois.readObject();
		f.pack();
		f.setVisible(true);
		Date d = (Date) ois.readObject();
		System.out.println("객체가 저장된 시간: "+d);
		
		ois.close();
		fis.close();
	}

}
