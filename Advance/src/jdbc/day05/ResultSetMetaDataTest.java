package jdbc.day05;

import java.sql.*;
import java.util.*;
/* ResultSetMetaData 클래스
 *  - ResultSet에 관한 정보를 알 수 있는 클래스
 *    컬럼명, 컬럼의 자료형, 자료형 크기, 디스플레이 사이즈 등의 정보를 얄려줌
 * */

import jdbc.util.DBUtil;

public class ResultSetMetaDataTest {

	public static void main(String[] args)
	throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = DBUtil.getCon();
		System.out.println("쿼리문을 입력하세요=>");
		
		String sql ="";
		Statement st = con.createStatement();
		ResultSet rs=null;
		while((sql=sc.nextLine())!=null) {
			//";"가 위치한 인덱스 정보를 받자.
			int index = sql.indexOf(";");
			//";"가 없다면 -1을 반환함
			if(index!=-1) {
				sql=sql.substring(0, index);
			}
			
			boolean isSel = st.execute(sql);
			if(isSel) {
				//SELECT문
				rs=st.getResultSet();
				showMetaData(rs);
				rs=st.executeQuery(sql);
				while(rs.next()) {
					int idx=rs.getInt(1);
					String name=rs.getString(2);
					String msg = rs.getString(3);
					System.out.println(idx+"  "+name+"  "+msg);
				}
			}else {
				//SELECT문이 아닐 경우
				int cnt = st.getUpdateCount();
				System.out.println(cnt+"개의 레코드가 변경됨");
			}
		}
		
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(con!=null) con.close();
	}

	private static void showMetaData(ResultSet rs) 
	throws SQLException {
		//결과 테이블에 대한 메타 정보를 추출하자.
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		
		System.out.println("컬럼수: "+colCount);
		
		for(int i=1;i<=colCount;i++) {
			System.out.println("------------------");
			String colName = rsmd.getColumnName(i);
			String colType = rsmd.getColumnTypeName(i);
			int colSize = rsmd.getColumnDisplaySize(i);
			int n = rsmd.isNullable(i); //Not null=>0, null=>1 반환
			String str=(n==0)?"Not null":"null";
			System.out.println(colName+": "+colType+
					"["+colSize+"], "+str);
		}
		System.out.println("--------------------");
	}
}