package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.dao.BoardDao;
import co.mask.board.vo.BoardVo;
import co.mask.common.Command;

public class BoardWirte implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		vo.setBoardTitle(request.getParameter("boardTitle"));
		vo.setBoardWriter(request.getParameter("boardWriter"));
		vo.setBoardContent(request.getParameter("boardContent"));
//		vo.setBoardFile(request.getParameter("boardfile"));
		 
		dao.boardInsert(vo);
//		request.setAttribute("vo", vo);
		
		return "boardListForm.do";
	}

}
