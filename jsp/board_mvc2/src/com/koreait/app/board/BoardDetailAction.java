package com.koreait.app.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionTo;
import com.koreait.dao.BoardDAO;
import com.koreait.dto.BoardDTO;

public class BoardDetailAction implements Action {
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse rsp) throws Exception {
		BoardDAO bdao = new BoardDAO();
		String temp = req.getParameter("page");
		String keyword = req.getParameter("q");
		String boardnum = req.getParameter("boardnum");
		
		List<BoardDTO> boardDetail = bdao.getBoardDetail(boardnum);
		
		req.setAttribute("board", boardDetail);
		
		ActionTo transfer = new ActionTo();
		transfer.setRedirect(false);
		transfer.setPath("/app/board/getview.jsp");
		return transfer;
	}
}
