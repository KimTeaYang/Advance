package jdbc.day02;

import java.sql.*;
import jdbc.util.*;
import javax.swing.*;

public class MemoDelete {

	public static void main(String[] args) 
		throws Exception {
			String idxStr=JOptionPane.showInputDialog(
					"������ �� ��ȣ�� �Է��ϼ���");
			
			Connection con = DBUtil.getCon();
			
			String sql = "delete memo where idx="+idxStr;
			String sql1 = "SELECT * FROM MEMO";
			
			Statement stmt = con.createStatement();
			//int cnt = stmt.executeUpdate(sql);
			
			boolean b = stmt.execute(sql);
			int cnt = 0;
			if(!b) {
				cnt = stmt.getUpdateCount();
				// DML���忡 ���� ������� ���� ���� ��ȯ��
			}
			
			System.out.println(cnt+"���� ���ڵ尡 �����Ǿ����ϴ�.");
			
			b=stmt.execute(sql1);
			
			if(b) {
				ResultSet rs = stmt.getResultSet();
				while(rs.next()) {
					int idx = rs.getInt(1);
					String name = rs.getString(2);
					String msg = rs.getString(3);
					Date wdate = rs.getDate(4);
					System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
				}
				if(rs!=null) rs.close();
			}
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			
	}

}
