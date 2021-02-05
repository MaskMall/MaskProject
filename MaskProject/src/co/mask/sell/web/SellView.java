package co.mask.sell.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class SellView implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 구매 내역 페이지
		
		
		return "view/sell/sellView";
	}

}
