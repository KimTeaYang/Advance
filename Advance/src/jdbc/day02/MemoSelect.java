package jdbc.day02;

import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!");
	
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "scott", pwd = "tiger";
	
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB Connected..!");
			
			String sql = "SELECT idx, name, msg, wdate"
					+ " FROM memo"
					+ " ORDER BY 1 ASC";

			stmt = con.createStatement();
			// SQL���� SELECT���̸�
			// public ResultSet executeQuery()�� �̿�����.
			
			rs = stmt.executeQuery(sql);
			/* rs�� ��� ���̺��� ������
			 * ��� ���̺��� ������ Ŀ���� ù��° ���ڵ��� ������ ��ġ��
			 * public boolean next(): Ŀ���� ���� ���ڵ�� �̵���Ų ��,
			 * 	����Ű�� �ִ� ������ ���ڵ尡 ������ true�� ��ȯ�Ѵ�.
			 * */
			
			while(rs.next()) {
				int idx=rs.getInt("idx");
				String name = rs.getString("name");
				String msg = rs.getString("msg");
				java.sql.Date wdate = rs.getDate("wdate");
				System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			}
			
		}finally {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (con != null) con.close();
		}
	}
}
