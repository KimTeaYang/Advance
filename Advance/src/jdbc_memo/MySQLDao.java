package jdbc_memo;

import java.sql.*;

public class MySQLDao {
	private String url;
	private String user;
	private String pwd;
	Connection con;
	Statement stmt;
	ResultSet rs;
	ResultSetMetaData rsmd;
	
	public MySQLDao() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** DB와 연결하는 메소드 */
	public boolean dbConnect() throws SQLException {
		con = DriverManager.getConnection(url, user, pwd);
		boolean b = (con!=null)? true:false;
		if(b) {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		}
		return b;
	}
	
	/** SQL문을 실행시키는 메소드 */
	public Object execute(String sql) throws SQLException {
		boolean b = stmt.execute(sql);
		
		if(b) {
			// SELECT 문
			rs = stmt.getResultSet();
			return rs;
		}else {
			// DML 문
			int cnt = stmt.getUpdateCount();
			return cnt;
		}
	}

	public void close() {
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String[] getColumInfo(ResultSet obj) 
	throws SQLException {
		rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		String[] colNames = new String[colCount];
		for(int i=0;i<colNames.length;i++) {
			colNames[i]=rsmd.getColumnName(i+1);
		}
		return colNames;
	}

	public Object[][] getInfo(ResultSet obj) 
	throws SQLException {
		rsmd = obj.getMetaData();
		int cnt=0;
		while(obj.next()) {
			cnt++;
		}
		Object[][] data= new Object[cnt][rsmd.getColumnCount()];
		cnt--;
		while(obj.previous()) {
			data[cnt][0]=obj.getInt(1);
			data[cnt][1]=obj.getString(2);
			data[cnt][2]=obj.getString(3);
			data[cnt][3]=obj.getDate(4);
			cnt--;
		}
		return data;
	}
	
}