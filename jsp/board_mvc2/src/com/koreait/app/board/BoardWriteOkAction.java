package com.koreait.app.board;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.Action;
import com.koreait.action.ActionTo;
import com.koreait.dao.BoardDAO;
import com.koreait.dao.FileDAO;
import com.koreait.dto.BoardDTO;
import com.koreait.dto.FileDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BoardWriteOkAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		//cos : http://www.servlets.com
		String saveFolder = req.getServletContext().getRealPath("file");
		System.out.println(saveFolder);
		
		//저장될 파일의 크기(5MB)
		int size = 1024 * 1024 * 5;
		
		//cos 라이브러리 이용
		MultipartRequest multi = new MultipartRequest(req, saveFolder, size,
				"UTF-8", new DefaultFileRenamePolicy());
		
		boolean fcheck1 = false;
		boolean fcheck2 = false;
		
		//					input[type=file] 태그의 name값을 써주면 시스템상 이름을 받아올 수 있음
		String systemname1 = multi.getFilesystemName("file1");
		if(systemname1 == null) {
			fcheck1 = true;
		}
		//					input[type=file] 태그의 name값을 써주면 사용자가 업로드할 당시의 이름을 받아올 수 있음
		String orgname1 = multi.getOriginalFileName("file1");

		//두번째 파일도 똑같이 진행
		String systemname2 = multi.getFilesystemName("file2");
		if(systemname2 == null) {
			fcheck2 = true;
		}
		String orgname2 = multi.getOriginalFileName("file2");
		
		BoardDTO board = new BoardDTO();
		board.setBoardtitle(multi.getParameter("boardtitle"));
		board.setBoardcontents(multi.getParameter("boardcontents"));
		String userid = multi.getParameter("userid");
		board.setUserid(userid);
		
		BoardDAO bdao = new BoardDAO();
		ActionTo transfer = new ActionTo();
		int boardnum = 0;
		
		if(bdao.insertBoard(board)) {
			FileDAO fdao = new FileDAO();
			boardnum = bdao.getLastNum(userid); 
			if(!fcheck1) {
				FileDTO file = new FileDTO();
				file.setBoardnum(boardnum);
				file.setOrgname(orgname1);
				file.setSystemname(systemname1);
				
				fcheck1 = fdao.insertFile(file);
			}
			if(!fcheck2) {
				FileDTO file = new FileDTO();
				file.setBoardnum(boardnum);
				file.setOrgname(orgname2);
				file.setSystemname(systemname2);
				
				fcheck2 = fdao.insertFile(file);
			}
			//1. 원래 파일이 업로드가 안됐음
			//2. 파일이 존재했고, 위의 DB처리까지 완벽하게 성공했음
			if(fcheck1 && fcheck2) {
				transfer.setRedirect(true);
				transfer.setPath(req.getContextPath()+"/board/boardview.bo?boardnum="+boardnum);
			}
		}
		else {
			transfer.setRedirect(true);
			transfer.setPath(req.getContextPath()+"/board/boardlist.bo");
			Cookie cookie = new Cookie("w", "f");
			resp.addCookie(cookie);
		}
		return transfer;
	}
}










