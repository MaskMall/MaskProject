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

import co.mask.admin.web.AdminFrom;
import co.mask.admin.web.AdminSellerForm;
import co.mask.admin.web.AdminUserForm;
import co.mask.admin.web.SellerDelete;
import co.mask.admin.web.SellerUpForm;
import co.mask.admin.web.SellerUpdate;
import co.mask.admin.web.UserDelete;
import co.mask.admin.web.UserUpForm;
import co.mask.admin.web.UserUpdate;
import co.mask.join.web.IdCheck;
import co.mask.join.web.Join;
import co.mask.join.web.JoinForm;
import co.mask.login.web.Login;
import co.mask.login.web.LoginForm;

import co.mask.main.MainPage;
import co.mask.main.Menu;

@WebServlet("/FrontController1")
public class FrontController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController1() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/menu.do", new Menu());
		map.put("/main.do", new MainPage());
		map.put("/joinForm.do", new JoinForm());	//회원가입 폼 호출
		map.put("/idCheck.do", new IdCheck());	//아이디 중복체크
		map.put("/join.do", new Join()); 	//회원가입
		map.put("/loginForm.do", new LoginForm());	//로그인 폼 호출
		map.put("/login.do", new Login()); 	//로그인
		map.put("/adminForm.do", new AdminFrom()); //관리자의 관리자창 폼 호출
		map.put("/adminUserForm.do", new AdminUserForm()); //관리자의 회원목록 폼 호출
		map.put("/userUpForm.do", new UserUpForm()); //관리자의 회원 수정 폼 호출
		map.put("/userUpdate.do", new UserUpdate()); //관리자의 회원 수정
		map.put("/userDelete.do", new UserDelete()); //관리자의 회원 삭제 
		map.put("/adminSellerForm.do", new AdminSellerForm()); //관리자의 거래처목록 폼 호출
		map.put("/sellerUpForm.do", new SellerUpForm()); //관리자의 거래처 수정 폼 호출
		map.put("/sellerUpdate.do", new SellerUpdate()); //관리자의 거래처 수정-----끝
		map.put("/sellerDelete.do", new SellerDelete()); //관리자의 거래처 삭제
		
		
		
//		map.put("/myPage", new MyPage());	//유저의 마이페이지 폼 호출
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
