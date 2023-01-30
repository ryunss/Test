package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.domain.BoardDTO;
import com.koreait.domain.Criteria;
import com.koreait.domain.PageDTO;
import com.koreait.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		//type:T, keyword:제목1, pagenum:7
		//1. Criteria cri = new Criteria();	(pagenum:1/keyword:null/amount:10/startrow:0/type:null)
		//2. cri.setType("T"); (pagenum:1/keyword:null/amount:10/startrow:0/type:T)
		//3. cri.setKeyword("제목1"); (pagenum:1/keyword:제목1/amount:10/startrow:0/type:T)
		//4. cri.setPagenum(7); (pagenum:7/keyword:제목1/amount:10/startrow:60/type:T)
		
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",new PageDTO(service.getTotal(cri), cri));
	}
	
	@GetMapping("/regist")
	public void regist(Criteria cri,Model model) {
		model.addAttribute("cri",cri);
	}
	@PostMapping("/regist")
	public String regist(BoardDTO board, RedirectAttributes ra) {
		service.regist(board);
		Long boardnum = service.getMaxBoardnum(board.getUserid());
		ra.addFlashAttribute("boardnum",boardnum);
		return "redirect:/board/list";
	}
	@GetMapping({"/get", "/modify"})
	public void get(Long boardnum, @ModelAttribute("cri")Criteria cri, Model model) {
		model.addAttribute("board",service.getDetail(boardnum));
//		model.addAttribute("cri",cri); @ModelAttribute 를 사용하면 수집하자마자 다시 모델에 담긴다.
									// 그래서 저렇게 모델에 안담아도 됨.
									// @ModelAttribute("키값") :
									// 데이터를 수집하자마자 해당하는 키값으로 Model에 attribute로 추가
	}
	@PostMapping("/remove")
	public String remove(Long boardnum, Criteria cri) {
		service.remove(boardnum);
		return "redirect:/board/list"+cri.getListLink();
	}
	@PostMapping("/modify")
	public String modify(BoardDTO board, Criteria cri, RedirectAttributes ra) {
		if(service.modify(board)) {
			ra.addFlashAttribute("s", board.getBoardnum());
		}else {
			ra.addFlashAttribute("f","f");
		}
		return "redirect:/board/get"+cri.getListLink()+"&boardnum="+board.getBoardnum();
	}
}







