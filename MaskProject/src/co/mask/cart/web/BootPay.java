package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;

public class BootPay implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 부트페이 결제 시스템
		CartDao dao = new CartDao();
		CartVo vo = new CartVo();
		vo.setCartNum(Integer.parseInt(request.getParameter("cartNum")));
		vo.setCartUser(request.getParameter("cartUser"));
		
		dao.select(vo);
		request.setAttribute("vo", vo);

		System.out.println(vo.getProductPrice());
		
		return "view/cart/bootPay";
	}

}
