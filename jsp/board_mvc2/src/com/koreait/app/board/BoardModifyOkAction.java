package com.koreait.app.board;

import java.io.File;
import java.util.List;

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

public class BoardModifyOkAction implements Action{
	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String saveFolder = req.getServletContext().getRealPath("file");
		int size = 1024*1024*5;
		
		MultipartRequest multi = new MultipartRequest(req, saveFolder, size, "UTF-8",
				new DefaultFileRenamePolicy());
		
		int boardnum = Integer.parseInt(multi.getParameter("boardnum"));
		String boardtitle = multi.getParameter("boardtitle");
		String boardcontents = multi.getParameter("boardcontents");
		String q = multi.getParameter("q");
		String page = multi.getParameter("page");
		
		BoardDTO board = new BoardDTO();
		board.setBoardtitle(boardtitle);
		board.setBoardcontents(boardcontents);
		board.setBoardnum(boardnum);
		
		ActionTo transfer = new ActionTo();
		transfer.setRedirect(true);
		
		BoardDAO bdao = new BoardDAO();
		FileDAO fdao = new FileDAO();
		
		if(bdao.updateBoard(board)) {
			String[] systemname = {multi.getFilesystemName("file1"),multi.getFilesystemName("file2")};
			String[] orgname = {multi.getOriginalFileName("file1"),multi.getOriginalFileName("file2")};
			
			//원래 이 글에 등록되어 있는 파일의 정보들
			List<FileDTO> files = fdao.getFiles(boardnum);
			
			//새롭게 이 게시글이 가지고 있어야 하는 파일들의 이름들
			String[] newFilenames = multi.getParameterValues("filename");
			
			int cnt = 0;
			for(int i=0;i<newFilenames.length;i++) {
				if(newFilenames[i] != null && !newFilenames[i].equals("")) {
					cnt++;
				}
			}
			
			//cnt : 실제로 이 게시글이 가지고 있는 파일의 개수
			for(int i=0;i<cnt;i++) {
				if(systemname[i] == null) {
					//실제 게시판이 가져야 하는 파일의 개수만큼 반복을 하면서 날라온 file태그의 데이터를 검사하는것
					//이 if문에 들어왔다면 가져야 하는 개수 안쪽이지만, 실제 파일 데이터는 없다는 뜻이므로
					//기존 파일에서 수정을 하지 않았다는 뜻
				}
				else {
					//무언가 수정이 일어났다는 뜻
					if(files.size() > i) {
						//이 if문에 들어왔다면 기존에 존재하던 파일 대신에 새로운 파일을 올렸다는 뜻
						//기존에 존재하는 file을 객체로 가져온 후
						File file = new File(saveFolder,files.get(i).getSystemname());
						//실제 파일이 존재한다면
						if(file.exists()) {
							//해당 파일 삭제
							file.delete();
							//실제 파일이 삭제되었으므로 DB상에서도 정보를 지워주어야 한다.
							fdao.deleteByName(files.get(i).getSystemname());
						}
					}
					//새롭게 올렸거나 혹은 수정된 파일의 정보를 DB에 저장
					FileDTO fdto = new FileDTO();
					fdto.setBoardnum(boardnum);
					fdto.setOrgname(orgname[i]);
					fdto.setSystemname(systemname[i]);
					fdao.insertFile(fdto);
				}
			}
			transfer.setPath(req.getContextPath()+"/board/boardview.bo?boardnum="+boardnum+"&page="+page+"&q="+q);
		}
		else {
			transfer.setPath(req.getContextPath()+"/board/boardview.bo?boardnum="+boardnum+"&page="+page+"&q="+q);
		}
		return transfer;
	}

}










