package jdbc.day05;

import java.sql.*;
import jdbc.util.*;
/* ���� ���� sql���� �Ѳ����� �����ϴ� �ϰ�ó�� ���
 *  - ���� ���� sql���� �ۼ��Ͽ� Statement�� addBatch(String sql),
 *    executeBatch()�޼ҵ�� �ϰ� ó���Ѵ�.
 * */

public class BatchQuery {

	public static void main(String[] args) 
	throws Exception {
		
		Connection con = DBUtil.getCon();
		con.setAutoCommit(false); //�ڵ� Ŀ�� ���
		
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'��浿','BATCH�׽�Ʈ11',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'���浿','BATCH�׽�Ʈ21',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'�ֱ浿','BATCH�׽�Ʈ31',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'�̱浿','BATCH�׽�Ʈ41',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'ȫ�浿','BATCH�׽�Ʈ51',SYSDATE)");
		
		boolean isCommit=false;
		try {
			int[] updateCnt = stmt.executeBatch();
			isCommit = true;
		} catch (SQLException e) {
			isCommit = false;
			e.printStackTrace();
		}
		
		// Ʈ����� ó��.. ���� �����ؾ� commit.. �ϳ��� �����ϸ� rollback
		if(isCommit) con.commit();
		else con.rollback();
		
		con.setAutoCommit(true); // �ڵ�Ŀ������ ����
		
		String sql = "SELECT * FROM MEMO ORDER BY IDX DESC";
		
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			String name = rs.getString("name");
			String msg = rs.getString("msg");
			System.out.println(name+"\t"+msg);
		}
		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}
}