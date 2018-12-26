package jdbc_memo;

import java.sql.*;
import java.util.*;
import jdbc.util.*;

/* DAO (Data Access Object)
 *  - biz logic을 갖는 클래스
 *  - Persistence 계층(영속성 계층)
 *    DB에 접근하여 insert, delete, update, select 등을 수행한다.
 * */
public class MemoDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	/** 한줄 메모를 등록하는 메소드
	 *   - INSERT문을 수행한다.
	 * */
	public int insertMemo(MemoVO memo) {
		try {
			con = DBUtil.getCon();
			
			String sql = "INSERT INTO MEMO"
					+ " VALUES(MEMO_SEQ.NEXTVAL,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}
	
	/** 모든 글 목록 가져오기 (R)
	 *   - SELECT문을 수행
	 * */
	
	public ArrayList<MemoVO> listMemo(){
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM MEMO"
					+ " ORDER BY IDX ASC";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ArrayList<MemoVO> arr = makeList(rs);
			
			return arr;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
	public ArrayList<MemoVO> makeList(ResultSet rs)
		throws SQLException {
			ArrayList<MemoVO> arr = new ArrayList<>();
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String msg = rs.getString(3);
				java.sql.Date wdate = rs.getDate(4);
				
				MemoVO record = new MemoVO(idx,name,msg,wdate);
				arr.add(record);
			}
			return arr;
	}
	
	public MemoVO selectMemo(int idx) {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM MEMO"
					+ " WHERE IDX=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, idx);
			rs = ps.executeQuery();
			
			ArrayList<MemoVO> arr = makeList(rs);
			if(arr!=null && arr.size()==1) {
				MemoVO mvo = arr.get(0);
				return mvo;
			}
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close();
		}
	}
	
	public int deleteMemo(MemoVO memo) {
		try {
			con = DBUtil.getCon();
			
			String sql = "DELETE FROM MEMO"
					+ " WHERE IDX=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, memo.getIdx());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
		}
	}
	
	/** 메모글을 수정처리하는 메소드
	 *   - UPDATE문을 수행
	 * */
	
	public int updateMemo(MemoVO memo) {
		try {
			con = DBUtil.getCon();
			
			String sql = "UPDATE MEMO"
					+ " SET NAME=?, MSG=?"
					+ " WHERE IDX=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, memo.getName());
			ps.setString(2, memo.getMsg());
			ps.setInt(3, memo.getIdx());
			
			int n = ps.executeUpdate();
			return n;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			close();
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
	/** 작성자 또는 메모내용으로 검색하는 메소드
	 *   - SELECT문을 수행 
	 *   - LIKE절 사용*/
	public ArrayList<MemoVO> findMemo(
			String colName, String keyword) {
		try {
			con = DBUtil.getCon();
			
			String sql = "SELECT * FROM MEMO"
					+ " WHERE "+colName+" LIKE ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+keyword+"%");
			rs = ps.executeQuery();
			
			ArrayList<MemoVO> arr = makeList(rs);
			
			return arr;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
}