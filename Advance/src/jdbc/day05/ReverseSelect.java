package jdbc.day05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.util.DBUtil;
/* ResultSet�� Ŀ���� ��������� �̵��غ���.
 * rs�� Ŀ���� ����Ʈ�� next()�� �����ϴ�.
 * Ŀ���� ��������� �̵���Ű���� 
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
		//Ŀ���� �������� ���ķ� �̵���Ű��.
		rs.afterLast(); // <=> beforeFirst() -- Default
		while(rs.previous()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			System.out.println(empno+"\t"+ename);
		}
		
		System.out.println("========================");
		
		rs.absolute(-2); // 2��° ������ �̵�
		System.out.println(rs.getInt(1)+": "+rs.getString(2));
		/* absolute(int n): �Ű������� ���: next(), ����: previous()
		 * first(): ù��° �࿡ ��ġ
		 * last(): ������ ��
		 * getRow():���� Ŀ���� ��ġ�� ���� ���ȣ ��ȯ
		 * */
		
		rs.close();
		ps.close();
		con.close();
	}
}