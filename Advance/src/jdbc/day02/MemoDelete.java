package jdbc.day02;

import java.sql.*;
import jdbc.util.*;
import javax.swing.*;

public class MemoDelete {

	public static void main(String[] args) 
		throws Exception {
			String idxStr=JOptionPane.showInputDialog(
					"삭제할 글 번호를 입력하세요");
			
			Connection con = DBUtil.getCon();
			
			String sql = "delete memo where idx="+idxStr;
			String sql1 = "SELECT * FROM MEMO";
			
			Statement stmt = con.createStatement();
			//int cnt = stmt.executeUpdate(sql);
			
			boolean b = stmt.execute(sql);
			int cnt = 0;
			if(!b) {
				cnt = stmt.getUpdateCount();
				// DML문장에 의해 영향받은 행의 수를 반환함
			}
			
			System.out.println(cnt+"개의 레코드가 수정되었습니다.");
			
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
