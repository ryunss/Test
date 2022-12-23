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
		// cos : http://www.servlets.com
		// 파일 업로드 가져오기 위한 라이브러리
														// app 안이라면 app/file 이런식으로.
		String saveFolder = req.getServletContext().getRealPath("file");
		System.out.println("saveFolder :"+saveFolder);
		
		// 저장될 파일의 크기
		int size = 1024 * 1024 * 5; // 5MB
		
		// cos 라이브러리 이용																// 기본파일 이름 설정 객체
		MultipartRequest multi = new MultipartRequest(req, saveFolder, size, "UTF-8", new DefaultFileRenamePolicy());
																					// 만약에 a 라는 파일이 있는데 또 들어오면 자동으로 a1
																					// 이런식으로 저장해주는 정책.
		boolean fcheck1 = false;
		boolean fcheck2 = false;
																					// ex) qr.png 가 2개있다 쳤을 때 
		//					input[type=file] 태그의 name값을 써주면 시스템상 이름을 받아올 수 있음			qr.png
		String systemname1 = multi.getFilesystemName("file1");
		if(systemname1 == null) {
			fcheck1 = true;
		}
		//					input[type=file] 태그의 name값을 써주면 사용자가 업로드할 당시의 이름을 받아올 수 있음	pr.png1
		String orgname1 = multi.getOriginalFileName("file1");
		
		String systemname2 = multi.getFilesystemName("file2");
		if(systemname2 == null) {
			fcheck1 = true;
		}
		String orgname2 = multi.getOriginalFileName("file2");
		
		BoardDTO board = new BoardDTO();
		// 멀티파트로 넘기는 순간 request 가 아닌 mutilpartrequest에서 꺼냄.
		// 원래는 꺼낼때 board.setBoardtitle(req.getParameter("boardtitle") 이런식.
		board.setBoardtitle(multi.getParameter("boardtitle")); 
		board.setBoardcontents(multi.getParameter("boardcontents"));
		String userid = multi.getParameter("userid");
		board.setUserid(userid);
		
		BoardDAO bdao = new BoardDAO();
		ActionTo transfer = new ActionTo();
		int boardnum = 0;
		
		if(bdao.insertBoard(board)) {
			FileDAO fdao = new FileDAO();
//			boardnum = bdao.getLastNum(userid); // 내가 등록한 게시글 중에 마지막글을 들고옴.
			if(!fcheck1) { // 업로드가 됏으면
				FileDTO file = new FileDTO();
				file.setBoardnum(boardnum);
				file.setOrgname(orgname1);
				file.setSystemname(systemname1);
				
//				fcheck1 = fdao.insertFile(file); // 결과값이 true아니면 false 나오는데 fcheck1 재사용해서 확인
			}
			if(!fcheck2) { // 업로드가 됏으면
				FileDTO file = new FileDTO();
				file.setBoardnum(boardnum);
				file.setOrgname(orgname2);
				file.setSystemname(systemname2);
				
//				fcheck2 = fdao.insertFile(file);
			}
			// 1. 원래 파일이 업로드가 안됐을떄
			// 2. 파일이 존재했고, 위의 DB처리까지 완벽하게 성공했을 때
			if(fcheck1 && fcheck2) {
				transfer.setRedirect(true);
				transfer.setPath(req.getContextPath()+"/board/boardview.bo?boardnum="+boardnum);
			}
		}else {
			transfer.setRedirect(true);
			transfer.setPath(req.getContextPath()+"/board/boardlist.bo");
			Cookie cookie = new Cookie("w", "f");
			resp.addCookie(cookie);
		}
		
		return transfer;
	}
	
}
