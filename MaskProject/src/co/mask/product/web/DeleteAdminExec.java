package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.member.vo.MemberVo;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class DeleteAdminExec implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// DeleteAdminExec.do 처리 메소드
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		MemberVo Mvo = new MemberVo();
		HttpSession session = request.getSession();
		
		String admin1=(String) session.getAttribute("memberAuth");
		System.out.println(admin1);
		
		Mvo.setMemberAuth(admin1);
		
		int n=dao.deleteAdmin(vo);
		
		return "showProduct.do";
	}

}
