package baseballreservation;

import java.sql.*;
import java.util.*;
import jdbc.util.*;

public class AdminDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public ArrayList<ManagerVO> idx_select() {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM MANAGER"
					+ " ORDER BY IDX ASC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<ManagerVO> arr = makeList(rs);
			
			return arr;
		} catch (SQLException e) {
			System.out.println("idx_select 오류: "+e);
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
	
	
	public ArrayList<AdminVO> pay_select() {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT IDX,PI.PAY_NUMBER,PI.TICKET_NUMBER,"
					+ "T.PLAY_NUMBER,T.SEAT_NUMBER,T.SEAT_PRICE"
					+ " FROM PAY P JOIN PAYINFO PI"
					+ " ON P.PAY_NUMBER = PI.PAY_NUMBER JOIN TICKET T"
					+ " ON T.TICKET_NUMBER = PI.TICKET_NUMBER"
					+ " ORDER BY PI.PAY_NUMBER ASC";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<AdminVO> arr = makeList1(rs);
			
			return arr;
		} catch (SQLException e) {
			System.out.println("pay_select 오류: "+e);
			return null;
		}finally {
			close();
		}
	}
	
	public ArrayList<AdminVO> makeList1(ResultSet rs)
			throws SQLException {
				ArrayList<AdminVO> arr = new ArrayList<>();
				while(rs.next()) {
					int idx = rs.getInt(1);
					int pay_number = rs.getInt(2);
					int ticket_number = rs.getInt(3);
					int play_number = rs.getInt(4);
					int seat_number = rs.getInt(5);
					int seat_price = rs.getInt(6);
					
					AdminVO record = new AdminVO(
							idx,pay_number,ticket_number,
							play_number,seat_number,seat_price);
					arr.add(record);
				}
				return arr;
	}
	
	//회원 탈퇴
	public int idx_delete(int idx) {
		try {
			con = DBUtil.getCon();
			String sql = "DELETE FROM MANAGER"
					+ " WHERE IDX=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("delete 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	// 결제전체 취소
	public int payAll_delete(int pay_number) {
		try {
			con = DBUtil.getCon();
			con.setAutoCommit(false);
			
			String sql = "DELETE FROM PAYINFO" 
					+ " WHERE PAY_NUMBER=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pay_number);

			int n = ps.executeUpdate();
			int n1 = 0;

			if (n > 0) {
				n1 = pay_delete(pay_number);
				if (n1 > 0) {
					con.commit();
				} else {
					con.rollback();
				}
			} else {
				con.rollback();
			}
			con.setAutoCommit(true);
			return n1;
		} catch (SQLException e) {
			System.out.println("delete 오류: " + e);
			return -1;
		} finally {
			close();
		}
	}
	
	// pay table 삭제
	public int pay_delete(int pay_number) {
		try {
			if(con==null||con.isClosed()) {
				con = DBUtil.getCon();
			}
			
			String sql = "DELETE FROM PAY" 
					+ " WHERE PAY_NUMBER=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, pay_number);

			int n = ps.executeUpdate();
			
			return n;
		} catch (SQLException e) {
			System.out.println("delete 오류: " + e);
			return -1;
		}
	}
	
	// ticket table 삭제
	public int ticket_delete(int play_number, int seat_number) {
		try {
			con = DBUtil.getCon();
			con.setAutoCommit(false);
				
			String sql = "DELETE FROM TICKET" 
					+ " WHERE PLAY_NUMBER=? AND SEAT_NUMBER=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, play_number);
			ps.setInt(2, seat_number);

			int n = ps.executeUpdate();
			int n1 = 0;

			if (n > 0) {
				n1 = seat_update(play_number, seat_number);
				if (n1 > 0) {
					con.commit();
				} else {
					con.rollback();
				}
			} else {
				con.rollback();
			}
			con.setAutoCommit(true);
			return n1;
		} catch (SQLException e) {
			System.out.println("delete 오류: " + e);
			return -1;
		} finally {
			close();
		}
	}
	
	// seat table 업데이트
	public int seat_update(int play_number, int seat_number) {
		try {
			if(con==null||con.isClosed()) {
				con = DBUtil.getCon();
			}
					
			String sql = "UPDATE SEAT SET SEAT_OX='NO'" 
					+ " WHERE PLAY_NUMBER=? AND SEAT_NUMBER=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, play_number);
			ps.setInt(2, seat_number);

			int n = ps.executeUpdate();
					
			return n;
		} catch (SQLException e) {
			System.out.println("delete 오류: " + e);
			return -1;
		}
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