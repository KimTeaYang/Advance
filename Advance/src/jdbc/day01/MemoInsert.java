package jdbc.day01;

import java.sql.*;
import javax.swing.*;

public class MemoInsert {

	public static void main(String[] args) 
	throws ClassNotFoundException, SQLException {
		
		String name = JOptionPane.showInputDialog(
				"작성자를 입력하세요");
		String msg = JOptionPane.showInputDialog(
				"메모 내용을 입력하세요");
		System.out.println(name+"/"+msg);
		/* [실습]
		 *  사용자가 입력한 메모내용과 작성자가 memo테이블에 insert 되도록 하세요.
		 *  글번호는 시퀀스를 증가시켜 입력되도록 하세요.
		 * */
		
		// 1. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		/* OracleDriver객체를 생성해서 메모리에 올리고 드라이버를 DriverManager에
		 * 등록해준다. DriverManager는 드라이버를 관리하는 클래스로 드라이버들을
		 * 벡터에 저장하여 관리한다.
		 * */
		
		// 2. DB연결
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="scott", pwd="tiger";
		
		Connection con = DriverManager.getConnection(url, user, pwd);
		
		// 3. sql문 작성=> memo테이블에 insert하는 문장을 작성
		String sql = "Insert into memo(idx,name,msg)"
				+ " Values(MEMO_SEQ.NEXTVAL,'"+name+"','"+msg+"')";
		System.out.println(sql);
		
		// 4. Statement 얻기
		Statement stmt = con.createStatement();
		
		// 5. Statement의 execute() 호출
		Boolean isSel = stmt.execute(sql);
		System.out.println(isSel);
		
		// 6. DB관련 자원 반납
		if(stmt!=null) stmt.close();
		if(con!=null) con.close();
	}

}
