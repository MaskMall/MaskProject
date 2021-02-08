package co.mask.product.web;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.cart.dao.CartDao;
import co.mask.cart.vo.CartVo;
import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class DeleteAdminExec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DeleteAdminExec.do 처리 메소드
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		
		HttpSession session = request.getSession();
		Object cartview =  session.getAttribute("cartProduct");
		String cview = (String)cartview;
		
		System.out.println(cview);
		
		if(cartview != null) {
			request.setAttribute("msg", "해당상품은 출고상품으로 삭제 불가능합니다.");
		}else {
			vo.setProductNum(Integer.parseInt(request.getParameter("row")));
			int n=dao.deleteAdmin(vo);
			System.out.println(n);
			request.setAttribute("vo", vo);
		}
		
		return "showProduct.do";
	}

}
