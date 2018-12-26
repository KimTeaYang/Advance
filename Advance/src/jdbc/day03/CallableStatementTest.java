package jdbc.day03;

import java.sql.*;
import javax.swing.*;

import jdbc.util.DBUtil;
/* CallableStatement Ȱ��
 *  - ���ν����� ȣ���� �� ����ϴ� Ŭ����
 *  - ���� ���ν����� �־�� ��.
 *  CREATE OR REPLACE PROCEDURE MEMO_ADD(
  		PNAME IN VARCHAR2,
  		PMSG IN VARCHAR2)
  	IS
    --���� ����
  	BEGIN
    --���๮
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
				"�ۼ��� �̸��� �Է��ϼ���");
		String msg = JOptionPane.showInputDialog(
				"�޸� ������ �Է��ϼ���");
		
		Connection con = DBUtil.getCon();
		// MEMO_ADD() ���ν����� ȣ���غ���.
		/* �ڹٿ��� ���ν��� ȣ���ϴ� ���
		 * [1] IN �Ķ���Ͱ� ���� ���
		 *  String sql="{call ���ν�����(���Ķ���Ͱ�)}";
		 * 
		 * [2] IN �Ķ���Ͱ� ���� ���
		 *  {call ���ν�����}
		 * 
		 * */
		String sql="{call MEMO_ADD(?,?)}";
		
		CallableStatement cstmt = con.prepareCall(sql);
		
		cstmt.setString(1, name);
		cstmt.setString(2, msg);
		
		boolean b = cstmt.execute();
		System.out.println("b="+b);
		
		System.out.println("MEMO_ADD()���ν��� �����");
		cstmt.close();
		con.close();
		
	}
}