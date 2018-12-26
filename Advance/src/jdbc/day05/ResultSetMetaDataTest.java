package jdbc.day05;

import java.sql.*;
import java.util.*;
/* ResultSetMetaData Ŭ����
 *  - ResultSet�� ���� ������ �� �� �ִ� Ŭ����
 *    �÷���, �÷��� �ڷ���, �ڷ��� ũ��, ���÷��� ������ ���� ������ �����
 * */

import jdbc.util.DBUtil;

public class ResultSetMetaDataTest {

	public static void main(String[] args)
	throws Exception {
		Scanner sc = new Scanner(System.in);
		Connection con = DBUtil.getCon();
		System.out.println("�������� �Է��ϼ���=>");
		
		String sql ="";
		Statement st = con.createStatement();
		ResultSet rs=null;
		while((sql=sc.nextLine())!=null) {
			//";"�� ��ġ�� �ε��� ������ ����.
			int index = sql.indexOf(";");
			//";"�� ���ٸ� -1�� ��ȯ��
			if(index!=-1) {
				sql=sql.substring(0, index);
			}
			
			boolean isSel = st.execute(sql);
			if(isSel) {
				//SELECT��
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
				//SELECT���� �ƴ� ���
				int cnt = st.getUpdateCount();
				System.out.println(cnt+"���� ���ڵ尡 �����");
			}
		}
		
		if(rs!=null) rs.close();
		if(st!=null) st.close();
		if(con!=null) con.close();
	}

	private static void showMetaData(ResultSet rs) 
	throws SQLException {
		//��� ���̺� ���� ��Ÿ ������ ��������.
		ResultSetMetaData rsmd = rs.getMetaData();
		int colCount = rsmd.getColumnCount();
		
		System.out.println("�÷���: "+colCount);
		
		for(int i=1;i<=colCount;i++) {
			System.out.println("------------------");
			String colName = rsmd.getColumnName(i);
			String colType = rsmd.getColumnTypeName(i);
			int colSize = rsmd.getColumnDisplaySize(i);
			int n = rsmd.isNullable(i); //Not null=>0, null=>1 ��ȯ
			String str=(n==0)?"Not null":"null";
			System.out.println(colName+": "+colType+
					"["+colSize+"], "+str);
		}
		System.out.println("--------------------");
	}
}