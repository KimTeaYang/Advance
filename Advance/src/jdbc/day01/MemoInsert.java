package jdbc.day01;

import java.sql.*;
import javax.swing.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException {
		
		String name = JOptionPane.showInputDialog(
				"�ۼ��ڸ� �Է��ϼ���");
		String msg = JOptionPane.showInputDialog(
				"�޸� ������ �Է��ϼ���");
		System.out.println(name+"/"+msg);
		/* [�ǽ�]
		 *  ����ڰ� �Է��� �޸𳻿�� �ۼ��ڰ� memo���̺� insert �ǵ��� �ϼ���.
		 *  �۹�ȣ�� �������� �������� �Էµǵ��� �ϼ���.
		 * */
		
		// 1. ����̹� �ε�
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/* OracleDriver��ü�� �����ؼ� �޸𸮿� �ø��� ����̹��� DriverManager��
		 * ������ش�. DriverManager�� ����̹��� �����ϴ� Ŭ������ ����̹�����
		 * ���Ϳ� �����Ͽ� �����Ѵ�.
		 * */
		
		// 2. DB����
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		// 3. sql�� �ۼ�=> memo���̺� insert�ϴ� ������ �ۼ�
		String sql = "Insert into memo(idx,name,msg)"
				+ " Values(MEMO_SEQ.NEXTVAL,'"+name+"','"+msg+"')";
		System.out.println(sql);
		
		// 4. Statement ���
		Statement stmt = con.createStatement();
		
		// 5. Statement�� execute() ȣ��
		Boolean isSel = stmt.execute(sql);
		System.out.println(isSel);
		
		// 6. DB���� �ڿ� �ݳ�
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}

}
