<<<<<<< HEAD
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
=======
package co.mask.product.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.common.Command;
import co.mask.product.dao.ProductDao;
import co.mask.product.vo.ProductVo;

public class ToUpdateProduct implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// ToUpdateProduct.do 처리 메소드
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		ProductDao dao = new ProductDao();
		ProductVo vo = new ProductVo();
		
		vo.setProductNum(Integer.parseInt(request.getParameter("productNum")));
		list=dao.select(vo);
		request.setAttribute("list", list);
		
		return "view/product/updateProductForm";
	}

}
>>>>>>> branch 'master' of https://github.com/MaskMall/MaskProject.git
