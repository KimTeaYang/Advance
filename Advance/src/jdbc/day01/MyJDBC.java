package jdbc.day01;

import java.sql.*;

/* JDBC 드라이버 설치
 [1] DBMS벤더 사 사이트에 가서 JDBC 드라이버를 다운로드 받는다.
  - C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib
 [2] ojdbc6.jar파일을 복사하여
  - C:\Java\jdk1.8.0_181\jre\lib\ext 아래에 붙여넣자
 [3] 오라클 데이터베이스 서버 실행
     리스너 실행되어 있어야 함.
*/

class MyJDBC {
	public static void main(String[] args) {
		try{
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!");

			// 2. Database 서버에 연결
			//  => DriverManager의 getConnection()메소드를 이용
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			// 프로토콜:dbms:드라이버유형:db서버host:port:sid
			String user = "scott", pwd = "tiger";

			Connection con = DriverManager.getConnection(url,user,pwd);
			System.out.println("DB연결 성공!!");
			
			// 3. SQL문 작성 - memo 테이블을 생성
			// (글번호, 작성자, 메모내용, 작성일)
			String sql = "CREATE TABLE memo(";
				sql+="idx number(4) primary key,";
				sql+="name varchar2(20) not null,";
				sql+="msg varchar2(100),";
				sql+="wdate date default sysdate)";
			System.out.println(sql);
			
			// 4. Statement 객체 얻기
			// => Connection을 통해 얻어온다. createStatement()를 이용
			Statement stmt = con.createStatement();
			
			// 5. Statement의 exeucteXXX()메소드를 통해 sql문 실행(전송)
			boolean isSel = stmt.execute(sql);
			// public boolean execute(String sql)
			//  : 모든 sql문을 실행시키는 메소드
			// 반환값 : sql문이 select문이면 true를 반환하고
			//  그 외의 문장이면 false를 반환한다.(여기면 create문장이므로 False)
			//  만일 sql문이 잘못 작성되었다면 SQLException을 발생시킨다.
			System.out.println("isSel= "+isSel);
			
			// 6. DB관련 자원 반납 => Statement를 close()
			if(stmt!=null) stmt.close();
			// DB연결 끊기. DB와 관련된 자원을 반납함.
			if(con!=null) con.close(); 
	
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패: "+e);
		}catch(SQLException e){
				System.out.println("SQL오류: "+e);
				e.printStackTrace();
		}
	}
}
