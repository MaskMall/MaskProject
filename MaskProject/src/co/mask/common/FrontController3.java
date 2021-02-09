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

import co.mask.board.web.BoardListForm;
import co.mask.board.web.BoardView;
import co.mask.board.web.BoardWirte;
import co.mask.board.web.BoardWriteForm;
import co.mask.board.web.Hedaer;
import co.mask.board.web.Notice;
import co.mask.main.MainPage;
import co.mask.main.Menu;



@WebServlet("/FrontController3")
public class FrontController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController3() {
        super();
        
    }
 
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainPage());
		map.put("/menu.do", new Menu()); //메뉴 확인하려고 index에서 바로 menu로 변경해보았습니다.
		
		
		map.put("/header.do", new Hedaer());
		map.put("/boardView.do", new BoardView());
		map.put("/notice.do", new Notice());
		
		map.put("/boardListForm.do", new BoardListForm());
		map.put("/boardWriteForm.do", new BoardWriteForm());
		map.put("/boardWirte.do", new BoardWirte());
		
		
	}


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		System.out.println(request.getContextPath() ); 프로젝트명
		String contexPath = request.getContextPath();
//		System.out.println(request.getRequestURI()); /MaskProject/boardWirteForm.do 프로젝트명->프론트컨트롤러에서 ..do를불러온다
		String uri = request.getRequestURI();
//		System.out.println(uri.substring(contexPath.length())); (시작)부터 끝까지 잘라낸 문자열
		String path = uri.substring(contexPath.length());
//		System.out.println(map.get(path)); null을 가져온다
//		System.out.println(path);// 메인으로가면 main.do 문의로가면  /boardListForm.do
		Command command = map.get(path); 
		System.out.println(command.execute(request, response));  // 가져오는값 view/main/main view/board/boardListForm
		String viewPage = command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
