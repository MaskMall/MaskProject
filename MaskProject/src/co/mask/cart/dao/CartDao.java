package co.mask.cart.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.mask.cart.vo.CartVo;
import co.mask.common.DAO;

public class CartDao extends DAO{
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public ArrayList<CartVo> selectList(CartVo vo){ // 유저 장바구니 리스트 조회
		ArrayList<CartVo> list = new ArrayList<CartVo>();
		String sql = "SELECT * FROM CART WHERE CARTUSER = ?";
		try { 
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			psmt.setString(1, vo.getCartUser());
			while (rs.next()) {
				vo = new CartVo();
				vo.setCartNum(rs.getInt("cartnum"));
				vo.setCartUser(rs.getString("cartuser"));
				vo.setCartProduct(rs.getInt("cartproduct"));
				vo.setCartSelect(rs.getInt("cartselect"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
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
