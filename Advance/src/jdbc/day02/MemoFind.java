package jdbc.day02;

import java.sql.*;
import javax.swing.*;
/* boolean execute(��� sql)
 * 
 * DQL(Data Query Language)
 * ResultSet executeQuery(select��)
 * 
 * DML(Data Manipulation Language)=>insert,update,delete
 * int executeUpdate(DML��)
 * */
public class MemoFind {

	public static void main(String[] args) 
		throws Exception{
		
		String findName = JOptionPane.showInputDialog(
				"�˻��� �ۼ��ڸ��� �Է��ϼ���");
		if(findName==null||findName.trim().equals("")) {
			System.out.println("�˻��� ����� �Է��ؾ� �ؿ�");
			return;
		}
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Loading Success!");
		
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		System.out.println("DB Connected..!");
		
		String sql1 = "select count(*) from memo "
				+ " where name='"+findName+"'";
		
		String sql = "SELECT * FROM MEMO"
				+ " WHERE NAME='"+findName+"'"
				+ " order by idx desc";
		
		Statement stmt = con.createStatement();
		
		ResultSet rs1 = stmt.executeQuery(sql1);
		
		
		if(rs1.next()) {
			int cnt=rs1.getInt(1);
			System.out.println("****************************");
			System.out.println(cnt+"���� ���� �־��");
			System.out.println("****************************");
		}
		rs1.close();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		int count=0;
		
		while(rs.next()) {
			count++;
			int idx = rs.getInt(1);
			String name = rs.getString(2);
			String msg = rs.getString(3);
			Date wdate = rs.getDate(4);
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		System.out.println("---------------------------------");
		System.out.println(count+"���� ���� �˻��Ǿ����ϴ�.");
		System.out.println("---------------------------------");
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}
}