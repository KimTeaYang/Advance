package javaChat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class Emoticon extends JFrame {
	JButton bt[]=new JButton[16];
	String str[]= {"T0","T1","T2","T3","T4","T5","T6","T7",
			"T8","T9","T10","T11","T12","T1","T2","T3"};
	JPanel p1;

	public Emoticon(MyChatGui myChatGui) {
		super("::Emoticon::");
		Container cp = this.getContentPane();
		
		p1 = new JPanel();
		cp.add(p1);
		p1.setLayout(new GridLayout(4, 4));
		
		for(int i=0;i<bt.length;i++) {
			bt[i]=new JButton(new ImageIcon("C:\\myjava\\Workspace\\Advance\\src\\images\\"+str[i]+".gif"));
			p1.add(bt[i]);
		}

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}