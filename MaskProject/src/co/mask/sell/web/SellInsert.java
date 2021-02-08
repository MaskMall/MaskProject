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
		
		vo.setSellProductNumber(Integer.parseInt(request.getParameter("productNum")));
		vo.setSellUser((String) session.getAttribute("memberId"));
		vo.setSellQunt(Integer.parseInt(request.getParameter("sellQunt")));
		
		dao.insert(vo);
		
		return "sellView.do";
	}

}
