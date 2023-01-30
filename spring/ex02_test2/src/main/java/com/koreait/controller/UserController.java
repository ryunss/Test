package com.koreait.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.domain.UserDTO;
import com.koreait.service.UserService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/user/*")
public class UserController {
	@Setter(onMethod_ = @Autowired)
	private UserService service;
	
//	@GetMapping("/join")
//	public void join() {
//		
//	}
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
			resp.addCookie(cookie);
		}
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(String userid, String userpw, HttpServletRequest req) {
		if(service.login(userid, userpw, req)) {
		}
		else {
		}
		return "home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		service.logout(req);
		return "home";
	}
}









