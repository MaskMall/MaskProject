package co.mask.sellChart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;
import co.mask.sellChart.dao.SellChartDao;
import co.mask.sellChart.vo.SellChartVo;

public class ChartInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 판매시 차트 db테이블 입력
		ProductDao pDao = new ProductDao();
		ProductVo pVo = new ProductVo();
		pVo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		
		pDao.select(pVo);
		
		SellChartDao dao = new SellChartDao();
		SellChartVo vo = new SellChartVo();
		vo.setChartProductNum(Integer.parseInt(request.getParameter("productNum")));
		vo.setChartSeller(pVo.getProductSeller());
		
		dao.select(vo);
		
		if(vo.getChartProduct() == null) {
			vo.setChartProduct(pVo.getProductName());
			vo.setChartProductNum(pVo.getProductNum());
			vo.setChartProductQunt(Integer.parseInt(request.getParameter("sellQunt")));
			vo.setChartSeller(pVo.getProductSeller());
			dao.insert(vo);
		} else {
			vo.setChartProductNum(pVo.getProductNum());
			vo.setChartProductQunt(vo.getChartProductQunt() + Integer.parseInt(request.getParameter("sellQunt")));
			vo.setChartSeller(pVo.getProductSeller());
			dao.update(vo);
		}
		
		return "buyerView.do";
	}

}
