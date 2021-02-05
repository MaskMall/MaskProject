package co.mask.product.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;

public class ToUpdateProduct implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// ToUpdateProductForm 가기
		return "view/product/updateProductForm";
	}

}
