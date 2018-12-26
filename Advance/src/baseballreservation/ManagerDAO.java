package baseballreservation;

import java.sql.*;
import java.util.*;
import jdbc.util.*;

public class ManagerDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	/** 한줄 메모를 등록하는 메소드
	 *   - INSERT문을 수행한다.
	 * */
	public int insertJoin(ManagerVO managerVO) {
		try {
			con = DBUtil.getCon();
			
			String sql = "INSERT INTO MANAGER"
					+ " VALUES(MANAGER_SEQ.NEXTVAL,?,?,?,?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, managerVO.getName());
			ps.setString(2, managerVO.getId());
			ps.setString(3, managerVO.getPwd());
			ps.setString(4, managerVO.getEmail());
			ps.setString(5, managerVO.getPh());
			ps.setString(6, managerVO.getAddr());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("insertJoin 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	public int delete(ManagerVO managerVO) {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM MANAGER"
					+ " WHERE IDX=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, managerVO.getIdx_pk());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("delete 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	public int update(ManagerVO managerVO) {
		try {
			con = DBUtil.getCon();
			
			String sql = "UPDATE MANAGER SET PWD=?,EMAIL=?,"
					+ "PH=?,ADDR=? WHERE ID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, managerVO.getPwd());
			ps.setString(2, managerVO.getEmail());
			ps.setString(3, managerVO.getPh());
			ps.setString(4, managerVO.getAddr());
			ps.setString(5, managerVO.getId());
			
			int n = ps.executeUpdate();
			return n;
			
		} catch (SQLException e) {
			System.out.println("update 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	public ArrayList<ManagerVO> select() {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM MANAGER";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<ManagerVO> arr = makeList(rs);
			
			return arr;
		} catch (SQLException e) {
			System.out.println("select 오류: "+e);
			return null;
		}finally {
			close();
		}
	}
	
	public ArrayList<ManagerVO> makeList(ResultSet rs)
			throws SQLException {
				ArrayList<ManagerVO> arr = new ArrayList<>();
				while(rs.next()) {
					int idx = rs.getInt(1);
					String name = rs.getString(2);
					String id = rs.getString(3);
					String pwd = rs.getString(4);
					String email = rs.getString(5);
					String ph = rs.getString(6);
					String addr = rs.getString(7);
					java.sql.Date indate = rs.getDate(8);
					
					ManagerVO record = new ManagerVO(
							idx,name,id,pwd,email,ph,addr,indate);
					arr.add(record);
				}
				return arr;
	}
	
	
	
	/** DB관련 자원을 반납하는 메소드 */
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}catch(SQLException e) {
			System.out.println("e: "+e);
		}
	}
}
