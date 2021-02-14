package co.mask.board.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.board.vo.BoardVo;
import co.mask.common.DAO;

public class BoardDao extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	private static BoardDao instance;

	public BoardDao() {
		super();
	}

	public static BoardDao getInstance() {
		if (instance == null)
			instance = new BoardDao();
		return instance;
	}

	public ArrayList<BoardVo> selectList() { // 議고��
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo vo;
		String sql = //"SELECT BOARTITLE, BOARDCONTENT, BOARDWRITER,BOARDDATE FROM BOARD WHERE BOARDNUMBER="+IDX; 
				"SELECT * FROM BOARD ORDER BY 1 DESC";
					
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVo();
				vo.setBoardNumber(rs.getInt("boardnumber"));
				vo.setBoardTitle(rs.getString("boardtitle"));
				vo.setBoardWriter(rs.getString("boardwriter"));
				vo.setBoardContent(rs.getString("boardcontent"));
				vo.setBoardDate(rs.getDate("boarddate"));
				vo.setBoardValue(rs.getString("boardvalue"));
				vo.setBoardHit(rs.getInt("boardhit"));
				list.add(vo);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int boardInsert(BoardVo vo) {
		int n = 0;
		
		String sql = "INSERT INTO BOARD " + "(BOARDNUMBER, BOARDWRITER, BOARDTITLE, BOARDCONTENT)"
				+ "VALUES(board_seq.nextval,?,?,?)";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardTitle());
			psmt.setString(2, vo.getBoardWriter());
			psmt.setString(3, vo.getBoardContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(); 
		}
		return n;
	}

	public int deleteBoard(BoardVo vo) {
		// ���� 荑쇰━
		int n = 0;
		String sql = "DELETE FROM BOARD WHERE BOARDNUMBER=?";
		try {

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNumber());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public void reWriteBoard(BoardVo vo) {
		// �듦�
	}

//	public ArrayList<BoardVo> getBoardList

	public void close() { // close 硫�����
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getSeq() {
		int result = 1;

		try {
			conn = DBConnection.getConnection();

			// ������ 媛��� 媛��몄�⑤�� (dual: �����ㅺ� 媛��몄�ㅻ�� �������대�)
			StringBuffer sql = new StringBuffer();
			sql.append("SELECT BOARDNUMBER.NEXTVAL FROM DUAL");

			psmt = conn.prepareStatement(sql.toString());

			rs = psmt.executeQuery();

			if (rs.next())
				result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		}
		close();

		return result;
	}

	public BoardVo select(BoardVo vo) {
		String sql = "SELECT * FROM BOARD WHERE BOARDNUMBER=?";
		String sql2 = "UPDATE BOARD SET BOARDHIT = BOARDHIT + 1 WHERE BOARDNUMBER = ?";
		try {
			psmt = conn.prepareStatement(sql2);
			psmt.setInt(1, vo.getBoardNumber());		
			rs = psmt.executeQuery();		
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getBoardNumber());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBoardNumber(rs.getInt("boardnumber"));
				vo.setBoardWriter(rs.getString("boardwriter"));
				vo.setBoardTitle(rs.getString("boardtitle"));
				vo.setBoardContent(rs.getString("boardcontent"));
				vo.setBoardDate(rs.getDate("boarddate"));
				vo.setBoardHit(rs.getInt("boardhit"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}

	public int boardUpdate(BoardVo vo) {
		int n = 0;
		String sql = "UPDATE BOARD SET BOARDTITLE=?, BOARDCONTENT=? WHERE BOARDNUMBER=?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardTitle());
			psmt.setString(2, vo.getBoardContent());
			psmt.setInt(3, vo.getBoardNumber());
			n = psmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		
		return n;
	}

	
//	public int boardHit(BoardVo vo) {
//		int n = 0;
//		String sql = "UPDATE BOARD SET BOARDHIT = BOARDHIT + 1 WHERE BOARDNUMBER = ?";
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			vo.setBoardNumber(rs.getInt("boardnumber"));
//			n = psmt.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close();
//		}
//		return n;
//	}
	
	
	
}
