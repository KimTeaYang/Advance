package jdbc.util;

import java.sql.*;

public class DBUtil {
	
	static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	static String user="semi";
	static String pwd="tiger";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success...");
			
		}catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Fail: "+e);
		}
	} // static block(static initializer) => main()메소드보다 먼저 실행
	
	public static Connection getCon() 
		throws SQLException {
			Connection con 
				= DriverManager.getConnection(url, user, pwd);
			return con;
	}
}