package co.mask.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.mask.join.web.IdCheck;
import co.mask.join.web.Join;
import co.mask.join.web.JoinForm;
import co.mask.login.web.Login;
import co.mask.login.web.LoginForm;

import co.mask.cart.web.CartView;
import co.mask.main.MainPage;
import co.mask.main.Menu;

@WebServlet("/FrontController")
public class FrontController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController1() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainPage());
		map.put("/joinForm.do", new JoinForm());	//회원가입 폼 호출
		map.put("/idCheck.do", new IdCheck());	//아이디 중복체크
		map.put("/join.do", new Join()); 	//회원가입
		map.put("/loginForm.do", new LoginForm());	//로그인 폼 호출
		map.put("/login.do", new Login()); 	//로그인
		map.put("/menu.do", new Menu()); //메뉴 확인하려고 index에서 바로 menu로 변경해보았습니다.
		//Cart
		map.put("/cartView.do", new CartView()); // 장바구니 리스트 페이지
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
