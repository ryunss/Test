package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.domain.PageDTO;
import com.koreait.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		// ex) type: T, keyword : 제목1, pagenum : 7
		// 1. Criteria cri = new Criteria(); -- 기본생성자 호출
					// 즉, pagenum = 1 / keword = null / amount = 10 / startrow = 0 / type = null
		// 2. cri.setType("T");
					// 즉, pagenum = 1 / keword = null / amount = 10 / startrow = 0 / type = T
		// 3. cri.setKeyword("제목1");
					// 즉, pagenum = 1 / keword = 제목1 / amount = 10 / startrow = 0 / type = T
		// 4. cri.setPagenum(7);
					// 즉, pagenum = 7 / keword = 제목1 / amount = 10 / startrow = 60 / type = T
		// 이런 순서로 진행된다.
		
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(service.getTotal(cri), cri));
	}
	
	@GetMapping("/regist")
	public void regist(Criteria cri, Model model) {
		model.addAttribute("cri", cri);
	}
	
	@PostMapping("/regist")
	public String regist(BoardDTO board, RedirectAttributes ra) {
										// 세션처럼 쓸 수 있는 공간이 만들어져있다.
										// 한번 쓰고나면 자동으로 없어진다.
										// 리다이렉트 하면 req 에 담겨있는 것들은 없어지기 때문에
										// redirectAttributes 사용. (스프링에서 제공)
		service.regist(board);
		int boardnum = service.getMaxBoardnum(board.getUserid());
		ra.addFlashAttribute("boardnum", boardnum);
		return "redirect:/board/list";
	}
	
	@GetMapping("/get")
	public void get(String boardnum, Model model) {
		model.addAttribute("board", service.getBoard(boardnum));
	}
}
