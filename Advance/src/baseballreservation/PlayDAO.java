package baseballreservation;

import java.sql.*;
import java.util.*;
import java.util.Date;
import jdbc.util.*;

public class PlayDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	// 경기 정보
	public ArrayList<PlayVO> play_select(int num) {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT PLAY_NUMBER, PLAY_REGION, PLAY_SCHEDULE"
					+ " FROM PLAY where play_number="+num;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<PlayVO> arr = makeList(rs);
			
			return arr;
		} catch (SQLException e) {
			System.out.println("select 오류: "+e);
			return null;
		}finally {
			close();
		}
	}
	// PlayVO 정보 
	public ArrayList<PlayVO> makeList(ResultSet rs)
			throws SQLException {
				ArrayList<PlayVO> arr = new ArrayList<>();
				while(rs.next()) {
					int play_number = rs.getInt(1);
					String play_region = rs.getString(2);
					java.sql.Date play_schedule = rs.getDate(3);
					
					PlayVO record = new PlayVO(
							play_number,play_region,play_schedule);
					arr.add(record);
				}
				return arr;
	}
	
	//좌석 정보
	public ArrayList<SeatVO> seat_select(int seatnum, int playnum) {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM SEAT"
					+ " WHERE SEAT_NUMBER="+seatnum+" AND PLAY_NUMBER="+playnum;
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<SeatVO> arr = makeList1(rs);
			
			return arr;
		} catch (SQLException e) {
			System.out.println("seat_select 오류: "+e);
			return null;
		}finally {
			close();
		}
	}
	// SeatVO 정보
	public ArrayList<SeatVO> makeList1(ResultSet rs)
			throws SQLException {
				ArrayList<SeatVO> arr = new ArrayList<>();
				while(rs.next()) {
					int play_number = rs.getInt(1);
					String play_region = rs.getString(2);
					int seat_number = rs.getInt(3);
					String seat_ox = rs.getString(4);
					String seat_grade = rs.getString(5);
					int seat_price = rs.getInt(6);
					Date play_schedule = rs.getDate(7);
					
					SeatVO record = new SeatVO(play_number,play_region,
							seat_number,seat_ox,seat_grade,seat_price,play_schedule);
					arr.add(record);
				}
				return arr;
	}
	
	// 티켓생성 및 좌석 현황 트랜잭션처리
	public int seat_ticket(int play_number1, int seat_number1,String YN,
			int play_number,String play_region,int seat_number,
			String seat_grade,int seat_price,Date play_schedule) {
		try {
			con = DBUtil.getCon();
			con.setAutoCommit(false);
			
			String sql = "INSERT INTO TICKET"
					+ " VALUES(TICKET_SEQ.NEXTVAL,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, play_number);
			ps.setString(2, play_region);
			ps.setInt(3, seat_number);
			ps.setString(4, seat_grade);
			ps.setInt(5, seat_price);
			ps.setDate(6, (java.sql.Date)play_schedule);
			
			int n = ps.executeUpdate();
			int n1 = 0;
			
			if(n>0) {
				n1 = seat_update(play_number1,seat_number1,YN);
				if(n1>0) {
					con.commit();
				}else {
					con.rollback();
				}
			}else {
				con.rollback();
			}
			con.setAutoCommit(true);
			return n1;
		} catch (SQLException e) {
			System.out.println("seat_ticket 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	// 좌석현황 변경
	public int seat_update(int play_number, int seat_number,String YN) {
		try {
			if(con==null||con.isClosed()) {
				con = DBUtil.getCon();
			}
			
			String sql = "UPDATE SEAT SET SEAT_OX=?"
					+ " WHERE PLAY_NUMBER=? AND SEAT_NUMBER=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, YN);
			ps.setInt(2, play_number);
			ps.setInt(3, seat_number);
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}/*finally {
			close();
		}*/
	}
	
	// 티켓 생성
	public int ticket_insert(int play_number,String play_region,int seat_number,
			String seat_grade,int seat_price,Date play_schedule) {
		try {
			con = DBUtil.getCon();
			
			String sql = "INSERT INTO TICKET"
					+ " VALUES(TICKET_SEQ.NEXTVAL,?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, play_number);
			ps.setString(2, play_region);
			ps.setInt(3, seat_number);
			ps.setString(4, seat_grade);
			ps.setInt(5, seat_price);
			ps.setDate(6, (java.sql.Date)play_schedule);
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("ticket_insert 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	// 예매 취소
	public int ticket_delete(int play_number, int seat_number, String YN) {
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
				n1 = seat_update(play_number, seat_number, YN);
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
	
	// 결제 관련
	public int pay_insert(int idx, int pay_price) {
		try {
			con = DBUtil.getCon();
			
			String sql = "INSERT INTO PAY"
					+ " VALUES(PAY_SEQ.NEXTVAL,?,?,?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, idx);
			ps.setInt(2, pay_price);
			ps.setString(3, "신용카드");
			ps.setString(4, "YES");
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("pay_insert 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	// 결제정보
	public int payinfo_insert(int pay_number, int ticket_number) {
		try {
			con = DBUtil.getCon();
			
			String sql = "INSERT INTO PAYINFO"
					+ " VALUES(?,?)";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, pay_number);
			ps.setInt(2, ticket_number);
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			System.out.println("payinfo_insert 오류: "+e);
			return -1;
		}finally {
			close();
		}
	}
	
	// 티켓 select
		public ArrayList<TicketVO> ticket_select(int play_number, int seat_number) {
			try {
				con = DBUtil.getCon();
				
				String sql = "SELECT * FROM TICKET"
						+ " WHERE PLAY_NUMBER="+play_number+" AND SEAT_NUMBER="+seat_number;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				ArrayList<TicketVO> arr = makeList2(rs);
				
				return arr;
			} catch (SQLException e) {
				System.out.println("select 오류: "+e);
				return null;
			}finally {
				close();
			}
		}
		// TicketVO 정보 
		public ArrayList<TicketVO> makeList2(ResultSet rs)
				throws SQLException {
					ArrayList<TicketVO> arr = new ArrayList<>();
					while(rs.next()) {
						int ticket_number = rs.getInt(1);
						int play_number = rs.getInt(2);
						String play_region = rs.getString(3);
						int seat_number = rs.getInt(4);
						String seat_grade = rs.getString(5);
						int seat_price = rs.getInt(6);
						Date play_schedule = rs.getDate(7);
						
						TicketVO record = new TicketVO(
								ticket_number,play_number,play_region,seat_number,
								seat_grade,seat_price,play_schedule);
						arr.add(record);
					}
					return arr;
		}
		
		// PAY select
		public ArrayList<PayVO> pay_select(int idx) {
			try {
				con = DBUtil.getCon();
				
				String sql = "SELECT * FROM PAY"
						+ " WHERE IDX="+idx;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				ArrayList<PayVO> arr = makeList3(rs);
				
				return arr;
			} catch (SQLException e) {
				System.out.println("select 오류: "+e);
				return null;
			}finally {
				close();
			}
		}
		
		// PayVO 정보 
		public ArrayList<PayVO> makeList3(ResultSet rs)
				throws SQLException {
			ArrayList<PayVO> arr = new ArrayList<>();
			while(rs.next()) {
				int pay_number = rs.getInt(1);
				int idx = rs.getInt(2);
				int pay_price = rs.getInt(3);
				String pay_way = rs.getString(4);
				String pay_ox = rs.getString(5);
				
				PayVO record = new PayVO(pay_number,idx,pay_price,pay_way,pay_ox);
				arr.add(record);
			}
			return arr;
		}
		
		// PAY select
		public ArrayList<MyPageVO> myPage_select(int idx) {
			try {
				con = DBUtil.getCon();
					
				String sql = "SELECT PI.PAY_NUMBER,PI.TICKET_NUMBER,"
						+ "T.PLAY_SCHEDULE,T.SEAT_NUMBER,T.SEAT_PRICE"
						+ " FROM PAYINFO PI JOIN PAY P"
						+ " ON PI.PAY_NUMBER = P.PAY_NUMBER"
						+ " JOIN TICKET T"
						+ " ON PI.TICKET_NUMBER = T.TICKET_NUMBER"
						+ " WHERE P.IDX="+idx;
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
						
				ArrayList<MyPageVO> arr = makeList4(rs);
						
				return arr;
			} catch (SQLException e) {
				System.out.println("myPage_select 오류: "+e);
				return null;
			}finally {
				close();
			}
		}
				
		// PayVO 정보 
		public ArrayList<MyPageVO> makeList4(ResultSet rs)
				throws SQLException {
			ArrayList<MyPageVO> arr = new ArrayList<>();
			
			while(rs.next()) {
				int pay_number_fk = rs.getInt(1);
				int ticket_number_fk = rs.getInt(2);
				Date play_schedule_fk1 = rs.getDate(3);
				int seat_number_fk1 = rs.getInt(4);
				int seat_price_fk1 = rs.getInt(5);
				
				MyPageVO record = new MyPageVO(pay_number_fk,
						ticket_number_fk,play_schedule_fk1,
						seat_number_fk1,seat_price_fk1);
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
