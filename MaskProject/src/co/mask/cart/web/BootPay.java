package co.mask.cart.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class BootPay implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 부트페이 결제 시스템
		return "view/cart/bootPay";
	}

}
