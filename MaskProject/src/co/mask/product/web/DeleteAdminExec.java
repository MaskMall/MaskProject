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
		String admin1="";
		try {
			admin1=((String) session.getAttribute("memberAuth"));
			if(admin1==null || !admin1.equals("ADMIN")) {
				request.setAttribute("msg", "삭제 권한이 없습니다.");
				System.out.println("멤버권한 세션값:" + admin1);
			}else {
				int n= dao.deleteAdmin(vo);
				
			}
		}finally {
			
		}
		
		return "showProduct.do";
	}

}
