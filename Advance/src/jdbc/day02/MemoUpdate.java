package jdbc.day02;

import java.sql.*;
import jdbc.util.DBUtil;
import javax.swing.*;

public class MemoUpdate {

	public static void main(String[] args) 
		throws Exception {
		
			String idxStr = JOptionPane.showInputDialog(
					"������ �� ��ȣ�� �Է��ϼ���");
			String nameStr=JOptionPane.showInputDialog(
					"������ �ۼ��ڸ� �Է��ϼ���");
			String msgStr=JOptionPane.showInputDialog(
					"������ �� ������ �Է��ϼ���");
		
		
			Connection con = DBUtil.getCon();
			System.out.println("DB�����: "+con);
			
			String sql="update memo set "
					+ "name='"+nameStr+"',"
					+ "msg='"+msgStr+"'"
					+ " where idx="+idxStr;
			
			String sql1 = "SELECT * FROM MEMO";
			
			Statement stmt = con.createStatement();
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt+"���� ���ڵ尡 �����Ǿ����ϴ�.");
			
			ResultSet rs = stmt.executeQuery(sql1);
			
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String msg = rs.getString(3);
				Date wdate = rs.getDate(4);
				System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
			}
			
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(con!=null) con.close();
			
	}

}