package co.mask.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.mask.common.DAO;
import co.mask.member.vo.MemberVo;

public class MemberDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	// 회원가입
	public int insert(MemberVo vo) {
		String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERPASSWORD, MEMBERNAME, MEMBERPHONE, MEMBERADDRESS, MEMBEREMAIL, MEMBERAUTH) VALUES (?, ?, ?, ?, ?, ?, ?)";
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberPhone());
			psmt.setString(5, vo.getMemberAddress());
			psmt.setString(6, vo.getMemberEmail());
			psmt.setString(7, vo.getMemberAuth());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 아이디 중복체크
	public boolean idCheck(String id) {
		boolean bool = true;
		String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if (rs.next()) {
				bool = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return bool;
	}

	// 로그인
	public MemberVo login(MemberVo vo) {
		String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD= ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setMemberName(rs.getString("MEMBERNAME"));
				vo.setMemberAuth(rs.getString("MEMBERAUTH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	public void close() { // close 메소드
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
}
