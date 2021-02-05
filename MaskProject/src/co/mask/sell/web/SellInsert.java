package co.mask.sell.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.sell.dao.SellDao;
import co.mask.sell.vo.SellVo;

public class SellInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 판매 완료시 Sell 테이블 입력
		SellDao dao = new SellDao();
		SellVo vo = new SellVo();
		vo.setSellNum(Integer.parseInt(request.getParameter("sellNum")));
		vo.setSellProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		dao.insert(vo);
		
		return "sellView.do";
	}

}
