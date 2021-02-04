package co.mask.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.mask.board.vo.BoardVo;
import co.mask.common.DAO;

public class BoardDao extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	
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
	
	
	public int insertBoard(BoardVo vo) {
		// 글쓰기
		int n = 0;
		String sql ="INSERT INTO BOARD "
				+ "( BOARDNUM, BOARDWRITER, BOARDCONTENT, BOARDDATE, BOARDLOCK,BOARDVALUE)"
				+ "VALUES(?,?,?,?,SYSDATE,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNum());
			psmt.setString(2, vo.getBoardTitle());
			psmt.setString(3, vo.getBoardWriter());
			psmt.setString(4, vo.getBoardContent());
			psmt.setDate(5, vo.getBoardDate());
			psmt.setInt(6, vo.getBoardLock());
			psmt.setString(7, vo.getBoardValue());
			
			n = psmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
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
	
	
	public void close() { //close 메소드
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
