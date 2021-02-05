package co.mask.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.RuntimeErrorException;

import co.mask.board.vo.BoardVo;
import co.mask.common.DAO;

public class BoardDao extends DAO{
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private static BoardDao instance;
	
	private BoardDao(){}
	
		public static BoardDao getInstance() {
			if(instance==null)
				instance=new BoardDao();
			return instance;
		}
	
	
	public int select(BoardVo vo) {
		int n = 0;
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNum());
			rs = psmt.executeQuery();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n ;
	}
	
	
	public boolean boardInsert(BoardVo vo) {
		// 글쓰기
		boolean result = false;
		
		try {
			String sql ="INSERT INTO BOARD "
					+ "( BOARDNUM, BOARDWRITER, BOARDTITLE, BOARDCONTENT, BOARDFILE)"
					+ "VALUES(?,?,?,?,?)";
			
			int n = vo.getBoardNum(); 
			
			psmt = conn.prepareStatement(sql.toString());
			psmt.setInt(1, vo.getBoardNum());
			psmt.setString(2, vo.getBoardTitle());
			psmt.setString(3, vo.getBoardWriter());
			psmt.setString(4, vo.getBoardContent());
			psmt.setString(5, vo.getBoardFile());
			
			n = psmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return result;
	}
	
	public int deleteBoard(BoardVo vo) {
			//삭제 쿼리
		int n = 0;
		String sql = "DELETE FROM BOARD WHERE NUM=?";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNum());
			n = psmt.executeUpdate();
					
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	
	public void reWriteBoard(BoardVo vo) {
		//답글
	}
	
	
//	public ArrayList<BoardVo> getBoardList
	
	
	
	public void close() { //close 메소드
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



	public int getSeq() {
		int result = 1;
		
		try {
			conn = DBConnection.getConnection();
			
			//시퀀스 값을 가져온다 (dual: 시퀀스값 가져오는 임시테이블)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT BOARDNUMBER.NEXTVAL FROM DUAL");
			
			psmt = conn.prepareStatement(sql.toString());
			
			rs = psmt.executeQuery();
			
			if(rs.next()) result = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		close();
		
		return result;
	}



}
