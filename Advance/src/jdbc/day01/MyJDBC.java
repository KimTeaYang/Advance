package jdbc.day01;

import java.sql.*;

/* JDBC ����̹� ��ġ
 [1] DBMS���� �� ����Ʈ�� ���� JDBC ����̹��� �ٿ�ε� �޴´�.
  - C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 [2] ojdbc6.jar������ �����Ͽ�
  - C:\Java\jdk1.8.0_181\jre\lib\ext �Ʒ��� �ٿ�����
 [3] ����Ŭ �����ͺ��̽� ���� ����
     ������ ����Ǿ� �־�� ��.
*/

class MyJDBC {
	public static void main(String[] args) {
		try{
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");

			// 2. Database ������ ����
			//  => DriverManager�� getConnection()�޼ҵ带 �̿�
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// ��������:dbms:����̹�����:db����host:port:sid
			String user = "scott", pwd = "tiger";

			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB���� ����!!");
			
			// 3. SQL�� �ۼ� - memo ���̺��� ����
			// (�۹�ȣ, �ۼ���, �޸𳻿�, �ۼ���)
			String sql = "CREATE TABLE memo(";
				sql+="idx number(4) primary key,";
				sql+="name varchar2(20) not null,";
				sql+="msg varchar2(100),";
				sql+="wdate date default sysdate)";
			System.out.println(sql);
			
			// 4. Statement ��ü ���
			// => Connection�� ���� ���´�. createStatement()�� �̿�
			Statement stmt = con.createStatement();
			
			// 5. Statement�� exeucteXXX()�޼ҵ带 ���� sql�� ����(����)
			boolean isSel = stmt.execute(sql);
			// public boolean execute(String sql)
			//  : ��� sql���� �����Ű�� �޼ҵ�
			// ��ȯ�� : sql���� select���̸� true�� ��ȯ�ϰ�
			//  �� ���� �����̸� false�� ��ȯ�Ѵ�.(����� create�����̹Ƿ� False)
			//  ���� sql���� �߸� �ۼ��Ǿ��ٸ� SQLException�� �߻���Ų��.
			System.out.println("isSel= "+isSel);
			
			// 6. DB���� �ڿ� �ݳ� => Statement�� close()
			if(stmt!=null) stmt.close();
			// DB���� ����. DB�� ���õ� �ڿ��� �ݳ���.
			if(con!=null) con.close(); 
	
			
		}catch(ClassNotFoundException e){
			System.out.println("����̹� �ε� ����: "+e);
		}catch(SQLException e){
				System.out.println("SQL����: "+e);
				e.printStackTrace();
		}
	}
}
