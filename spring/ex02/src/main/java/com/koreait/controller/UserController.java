package com.koreait.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.domain.UserDTO;
import com.koreait.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {
	private UserService service;
	
//	@GetMapping("/join")
//	public void join() {
//		
//	}
//	
//	@GetMapping("/login")
//	public void login() {
//		
//	}
	
	@GetMapping({"/join","/login"})
	public void replace() {}
	
	@PostMapping("/join")
	public String join(UserDTO user, HttpServletResponse resp) {
		if(service.join(user)) {
			Cookie cookie = new Cookie("joinid", user.getUserid());
			cookie.setMaxAge(300);
			resp.addCookie(cookie); // 이걸(쿠키) 사용하기 위해서 HttpServletResponse 를 매개변수로. 
		}
		return "redirect:/"; // home.jsp 이동.
	}
	
	@PostMapping("/login")
	public String login(String userid, String userpw, HttpServletRequest req) {
		if(service.login(userid, userpw, req)) {
			// 성공
		}else {
			// 실패
		}
		return "home"; // forward 로 home.jsp 이동.
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		service.logout(req);
		return "home";
	}
}
