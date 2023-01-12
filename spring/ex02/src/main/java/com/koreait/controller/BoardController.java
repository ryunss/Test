package com.koreait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.domain.Criteria;
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
	}
}
