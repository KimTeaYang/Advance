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
			// SQL문이 SELECT문이면
			// public ResultSet executeQuery()를 이용하자.
			
			rs = stmt.executeQuery(sql);
			/* rs가 결과 테이블을 참조함
			 * 결과 테이블의 논리적인 커서는 첫번째 레코드의 직전에 위치함
			 * public boolean next(): 커서를 다음 레코드로 이동시킨 뒤,
			 * 	가리키고 있는 지점에 레코드가 있으면 true를 반환한다.
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
