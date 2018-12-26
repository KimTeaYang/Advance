package jdbc.day03;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import jdbc.util.DBUtil;
import javax.swing.*;
/* PreparedStatement Ŭ����
 *  - �̸� �غ�� Statement
 *  - Statement�� executeXXX()�޼ҵ�� sql���� �����ų �� ����̹���
 *    dbms���˿� �°� �ش� �������� �������ϴ� �ݸ�,
 *    PreparedStatement�� �������� �̸� ������ ���� �غ��ص� ��,
 *    executeXXX()�޼ҵ尡 ȣ�� �� �� �Ķ���� �ι��� ������ �Ͽ� �����Ѵ�.
 * */

public class PreparedStatemanetTest {

	public static void main(String[] args) 
		throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.print("������ �Է�=>");
			String name = sc.next();
			
			//���Ͱ� �ǳʶٱ�
			sc.skip("\r\n");
			
			System.out.print("�޸𳻿� �Է�=>");
			String msg = sc.nextLine();
			
			System.out.println(name+"/"+msg);
			
			
			Connection con = DBUtil.getCon();
			System.out.println("DB�����");
			
			String sql="INSERT INTO MEMO(idx,name,msg,wdate)"
					+ " VALUES(MEMO_SEQ.NEXTVAL,?,?,SYSDATE)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, msg);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"���� ���� ������Ʈ �Ǿ����ϴ�.");
			
			if(pstmt!=null) pstmt.close();
			
			String sql1 = "SELECT * FROM MEMO"
					+ " ORDER BY IDX ASC";
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name1 = rs.getString(2);
				String msg1 = rs.getString(3);
				Date wdate = rs.getDate(4);
				System.out.println(idx+"\t"+name1+"\t"+msg1+"\t"+wdate);
			}
			
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			
			
			
	}
}