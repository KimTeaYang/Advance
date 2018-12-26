package jdbc.day05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.DBUtil;
/* ResultSet의 커서를 자유자재로 이동해보자.
 * rs의 커서는 디폴트로 next()만 가능하다.
 * 커서를 자유자재로 이동시키려면 
 * PreparedStatement ps = con.prepareStatement(sql,
 *  ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
 * */

public class ReverseSelect {

	public static void main(String[] args) 
	throws Exception {
		Connection con = DBUtil.getCon();
		
		String sql = "SELECT EMPNO,ENAME FROM EMP"
				+ " ORDER BY 1 ASC";
		
		PreparedStatement ps = con.prepareStatement(sql,
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		
		ResultSet rs = ps.executeQuery();
		//커서를 마지막행 직후로 이동시키자.
		rs.afterLast(); // <=> beforeFirst() -- Default
		while(rs.previous()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			System.out.println(empno+"\t"+ename);
		}
		
		System.out.println("========================");
		
		rs.absolute(-2); // 2번째 행으로 이동
		System.out.println(rs.getInt(1)+": "+rs.getString(2));
		/* absolute(int n): 매개변수가 양수: next(), 음수: previous()
		 * first(): 첫번째 행에 위치
		 * last(): 마지막 행
		 * getRow():실제 커서가 위치한 곳의 행번호 반환
		 * */
		
		rs.close();
		ps.close();
		con.close();
	}
}