package jdbc.day05;

import java.sql.*;
import jdbc.util.*;
/* 여러 개의 sql문을 한꺼번에 전송하는 일괄처리 방식
 *  - 여러 개의 sql문을 작성하여 Statement의 addBatch(String sql),
 *    executeBatch()메소드로 일괄 처리한다.
 * */

public class BatchQuery {

	public static void main(String[] args) 
	throws Exception {
		
		Connection con = DBUtil.getCon();
		con.setAutoCommit(false); //자동 커밋 취소
		
		Statement stmt = con.createStatement();
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'김길동','BATCH테스트11',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'윤길동','BATCH테스트21',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'최길동','BATCH테스트31',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'이길동','BATCH테스트41',SYSDATE)");
		stmt.addBatch("INSERT INTO MEMO VALUES("
				+ "MEMO_SEQ.NEXTVAL,'홍길동','BATCH테스트51',SYSDATE)");
		
		boolean isCommit=false;
		try {
			int[] updateCnt = stmt.executeBatch();
			isCommit = true;
		} catch (SQLException e) {
			isCommit = false;
			e.printStackTrace();
		}
		
		// 트랜잭션 처리.. 전부 성공해야 commit.. 하나라도 실패하면 rollback
		if(isCommit) con.commit();
		else con.rollback();
		
		con.setAutoCommit(true); // 자동커밋으로 복원
		
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