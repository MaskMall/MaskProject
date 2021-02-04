package co.mask.sell.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.common.DAO;
import co.mask.sell.vo.SellVo;

public class SellDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<SellVo> selectList() { // 판매완료 상품 목록 리스트
		ArrayList<SellVo> list = new ArrayList<SellVo>();
		SellVo vo;
		String sql = "SELECT * FROM SELL";

		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SellVo();
				vo.setSellNum(rs.getInt("sellnum"));
				vo.setSellProductNum(rs.getInt("sellproduct"));
				vo.setSellDate(rs.getDate("selldate"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int insert(SellVo vo) { // 구매한 상품 정보 입력
		int n = 0;
		String sql = "INSERT INTO sell values(?, ?, sysdate)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getSellNum());
			psmt.setInt(2, vo.getSellProductNum());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
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
