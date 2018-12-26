package jdbc.day03;

import java.sql.*;
import javax.swing.*;

import jdbc.util.DBUtil;
/* CallableStatement 활용
 *  - 프로시저를 호출할 때 사용하는 클래스
 *  - 내장 프로시저가 있어야 함.
 *  CREATE OR REPLACE PROCEDURE MEMO_ADD(
  		PNAME IN VARCHAR2,
  		PMSG IN VARCHAR2)
  	IS
    --변수 선언문
  	BEGIN
    --실행문
    	INSERT INTO MEMO
    	VALUES(MEMO_SEQ.NEXTVAL,PNAME,PMSG,SYSDATE);
    	COMMIT;
  	END;
  	/
 * */

public class CallableStatementTest {

	public static void main(String[] args)
		throws Exception {
		
		String name = JOptionPane.showInputDialog(
				"작성자 이름을 입력하세요");
		String msg = JOptionPane.showInputDialog(
				"메모 내용을 입력하세요");
		
		Connection con = DBUtil.getCon();
		// MEMO_ADD() 프로시저를 호출해보자.
		/* 자바에서 프로시저 호출하는 방법
		 * [1] IN 파라미터가 있을 경우
		 *  String sql="{call 프로시저명(인파라미터값)}";
		 * 
		 * [2] IN 파라미터가 없을 경우
		 *  {call 프로시저명}
		 * 
		 * */
		String sql="{call MEMO_ADD(?,?)}";
		
		CallableStatement cstmt = con.prepareCall(sql);
		
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		
		boolean b = cstmt.execute();
		System.out.println("b="+b);
		
		System.out.println("MEMO_ADD()프로시저 실행됨");
		cstmt.close();
		con.close();
		
	}
}