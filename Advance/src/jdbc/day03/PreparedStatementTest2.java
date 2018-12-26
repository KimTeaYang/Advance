package jdbc.day03;

import java.sql.*;
import java.util.Scanner;
import jdbc.util.DBUtil;

public class PreparedStatementTest2 {

	public static void main(String[] args) 
		throws Exception {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("�˻��� �μ� ��ȣ�� �Է�=>");
		int deptno = sc.nextInt();
		
		Connection con = DBUtil.getCon();
		System.out.println("DB�����");
		
		String sql1 = "SELECT COUNT(EMPNO) FROM EMP"
				+ " WHERE DEPTNO=?";
		
		pstmt = con.prepareStatement(sql1);
		pstmt.setInt(1, deptno);
		
		rs = pstmt.executeQuery();
		
		int cnt=0;
		while(rs.next()) {
			cnt=rs.getInt(1);
			System.out.println(cnt+"���� ���� �־��");
		}
		if(cnt<=0) return;

		String sql = "SELECT E.DEPTNO,DNAME,ENAME,JOB,HIREDATE"
				+ " FROM EMP E JOIN DEPT D"
				+ " ON E.DEPTNO = D.DEPTNO"
				+ " WHERE E.DEPTNO=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, deptno);
		
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int deptno1 = rs.getInt("DEPTNO");
			String dname = rs.getString("DNAME");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			Date hiredate = rs.getDate("HIREDATE");
			System.out.println(deptno1+"\t"+dname+"\t"+ename+"\t"+job+"\t"+hiredate);
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) con.close();
	}

}