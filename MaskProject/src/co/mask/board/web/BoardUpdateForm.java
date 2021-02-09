package co.mask.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mask.board.vo.BoardVo;
import co.mask.board.dao.BoardDao;
import co.mask.common.Command;

public class BoardUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		//게시글 수정 폼 호출
		vo.setBoardNumber(Integer.parseInt(request.getParameter("row")));
		
		 dao.select(vo);
		request.setAttribute("vo", vo);
		
		return "view/board/boardUpdateForm";
	}

}
