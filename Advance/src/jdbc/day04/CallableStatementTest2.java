package jdbc.day04;

import java.sql.*;
import jdbc.util.*;
import javax.swing.*;
/* CREATE OR REPLACE PROCEDURE EMP_LIST(
    PNO IN EMP.DEPTNO%TYPE,
    EMPCR OUT SYS_REFCURSOR)
   IS
   BEGIN
    OPEN EMPCR FOR
      SELECT D.DEPTNO, DNAME, EMPNO, ENAME, JOB
      FROM EMP E JOIN DEPT D
      ON E.DEPTNO = D.DEPTNO AND E.DEPTNO = PNO;
   END; 
   /
 * */
 

public class CallableStatementTest2 {

	public static void main(String[] args) 
		throws Exception {
		
		String pno = JOptionPane.showInputDialog(
				"부서번호를 입력하세요");
		
		Connection con = DBUtil.getCon();
		
		String sql = "{CALL EMP_LIST(?,?)}";
		CallableStatement cstmt = con.prepareCall(sql);
		
		cstmt.setInt(1, Integer.parseInt(pno)); //in parameter
		cstmt.registerOutParameter(
				2, oracle.jdbc.OracleTypes.CURSOR); // out parameter => 커서 유형
		
		cstmt.execute();
		ResultSet rs = (ResultSet)cstmt.getObject(2);
		
		while(rs.next()) {
			int deptno = rs.getInt("deptno");
			String dname = rs.getString("dname");
			int empno = rs.getInt("empno");
			String ename = rs.getString("ename");
			String job = rs.getString("job");
			System.out.println(deptno+"/"+dname+"/"+empno
					+"/"+ename+"/"+job);
		}
		
		rs.close();
		cstmt.close();
		con.close();
	}
}
