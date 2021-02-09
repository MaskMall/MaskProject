package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;

public class InputCart implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// InputCart.do 처리 메소드
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		HttpSession session = request.getSession();
		
		System.out.println(Integer.parseInt(request.getParameter("productNum")));
		vo.setCartUser((String) session.getAttribute("memberId"));
		vo.setCartProduct(Integer.parseInt(request.getParameter("productNum")));
		vo.setCartSelect(Integer.parseInt(request.getParameter("amount")));
		
		
		int n=dao.insert(vo);
		request.setAttribute("vo", vo);
		
		return "cartView.do";
	}

}
