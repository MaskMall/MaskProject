package co.mask.sellChart.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mask.common.Command;
import co.mask.sellChart.dao.SellChartDao;
import co.mask.sellChart.vo.SellChartVo;

public class ChartList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 차트 리스트
		ArrayList<SellChartVo> list = new ArrayList<SellChartVo>();
		SellChartDao dao = new SellChartDao();
		SellChartVo vo = new SellChartVo();
		HttpSession session = request.getSession();
		vo.setChartSeller((String)session.getAttribute("memberId"));
		
		list = dao.selectList(vo);
		request.setAttribute("chartList", list);
		
		return "view/sell/sellerView";
	}

}
