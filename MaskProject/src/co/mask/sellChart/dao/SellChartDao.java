package co.mask.sellChart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.common.DAO;
import co.mask.sellChart.vo.SellChartVo;

public class SellChartDao extends DAO {
	private PreparedStatement psmt;
	private ResultSet rs;

	public ArrayList<SellChartVo> selectList(SellChartVo vo) { // 차트 리스트 판매자별 조회
		ArrayList<SellChartVo> list = new ArrayList<SellChartVo>();
		String sql = "SELECT * FROM SELLCHART WHERE CHARTSELLER = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getChartSeller());
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SellChartVo();
				vo.setChartProduct(rs.getString("chartproduct"));
				vo.setChartProductNum(rs.getInt("chartproductnum"));
				vo.setChartProductQunt(rs.getInt("chartproductqunt"));
				vo.setChartSeller(rs.getString("chartseller"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public SellChartVo select(SellChartVo vo) { // 차트 한개 조회
		String sql = "SELECT * FROM SELLCHART WHERE CHARTPRODUCTNUM = ? AND CHARTSELLER = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getChartProductNum());
			psmt.setString(2, vo.getChartSeller());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setChartProduct(rs.getString("chartproduct"));
				vo.setChartProductNum(rs.getInt("chartproductnum"));
				vo.setChartProductQunt(rs.getInt("chartproductqunt"));
				vo.setChartSeller(rs.getString("chartseller"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	public int insert(SellChartVo vo) { // 차트 입력
		int n = 0;
		String sql = "INSERT INTO SELLCHART SET(?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getChartProduct());
			psmt.setInt(2, vo.getChartProductNum());
			psmt.setInt(3, vo.getChartProductQunt());
			psmt.setString(4, vo.getChartSeller());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	public int update(SellChartVo vo) { // 상품 판매 갯수 업데이트
		int n = 0;
		String sql = "UPDATE SELLCHART SET CHARTPRODUCTQUNT = ? WHERE CHARTSELLER = ? AND CHARTPRODUCTNUM = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getChartProductQunt());
			psmt.setString(2, vo.getChartSeller());
			psmt.setInt(3, vo.getChartProductNum());
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
