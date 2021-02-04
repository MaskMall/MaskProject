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

import co.mask.main.MainPage;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainPage());
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
