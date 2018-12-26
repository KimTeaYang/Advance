package jdbc.day03;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import jdbc.util.DBUtil;
import javax.swing.*;
/* PreparedStatement 클래스
 *  - 미리 준비된 Statement
 *  - Statement는 executeXXX()메소드로 sql문을 실행시킬 때 드라이버가
 *    dbms포맷에 맞게 해당 쿼리문을 컴파일하는 반면,
 *    PreparedStatement는 쿼리문을 미리 컴파일 시켜 준비해둔 뒤,
 *    executeXXX()메소드가 호출 될 때 파라미터 부문만 컴파일 하여 전송한다.
 * */

public class PreparedStatemanetTest {

	public static void main(String[] args) 
		throws Exception {
			Scanner sc = new Scanner(System.in);
			System.out.print("작정자 입력=>");
			String name = sc.next();
			
			//엔터값 건너뛰기
			sc.skip("\r\n");
			
			System.out.print("메모내용 입력=>");
			String msg = sc.nextLine();
			
			System.out.println(name+"/"+msg);
			
			
			Connection con = DBUtil.getCon();
			System.out.println("DB연결됨");
			
			String sql="INSERT INTO MEMO(idx,name,msg,wdate)"
					+ " VALUES(MEMO_SEQ.NEXTVAL,?,?,SYSDATE)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, msg);
			
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt+"개의 행이 업데이트 되었습니다.");
			
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