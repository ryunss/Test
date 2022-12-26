package com.koreait.app.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionTo;
import com.koreait.dao.BoardDAO;
import com.koreait.dao.FileDAO;
import com.koreait.dto.BoardDTO;

public class BoardViewAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boardnum = Integer.parseInt(req.getParameter("boardnum"));
//		int page = Integer.parseInt(req.getParameter("page"));
//		String q = req.getParameter("q");
		HttpSession session = req.getSession();
		
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		BoardDTO board = bdao.getDetail(boardnum);
		String userid = (String)session.getAttribute("loginUser");
		
		if(!board.getUserid().equals(userid)) {
			bdao.updateReadcount(boardnum);
			board.setReadcount(board.getReadcount()+1);
		}
		
		req.setAttribute("board", board);
		req.setAttribute("files", fdao.getFiles(boardnum));
		
		ActionTo transfer = new ActionTo();
		transfer.setRedirect(false);
		transfer.setPath("/app/board/getview.jsp");
		
		return transfer;
	}
}




