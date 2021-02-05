package co.mask.sell.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.sell.dao.SellDao;
import co.mask.sell.vo.SellVo;

public class SellInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 판매 완료시 Sell 테이블 입력
		SellDao dao = new SellDao();
		SellVo vo = new SellVo();
		HttpSession session = request.getSession();
		
		vo.setSellNumber(Integer.parseInt(request.getParameter("sellNumber")));
		vo.setSellProductNumber(Integer.parseInt(request.getParameter("productNumber")));
		vo.setMemberId((String) session.getAttribute("memberId"));
		
		dao.insert(vo);
		
		return "sellView.do";
	}

}
