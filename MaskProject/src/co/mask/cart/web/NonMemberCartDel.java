package co.mask.cart.web;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class NonMemberCartDel implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 비회원 장바구니 삭제 기능
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		HttpSession session = request.getSession();

		if (request.getParameter("productNum") != null) {
			vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
			dao.select(vo);
			vo.setAmount(Integer.parseInt(request.getParameter("amount")));

			@SuppressWarnings({ "unchecked", "rawtypes" })
			ArrayList<ProductVo> arr = (ArrayList) session.getAttribute("NonMemberList");
			
			Iterator<ProductVo> iter = arr.iterator();
			while (iter.hasNext()) {
				ProductVo obj = iter.next();
				if (obj.getProductNum() == Integer.parseInt(request.getParameter("productNum"))) {
					iter.remove();
				}
			}
			session.setAttribute("NonMemberList", arr);
		}
		return "view/cart/nonMemberCart";
	}

}
