package com.koreait.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.domain.UserDTO;
import com.koreait.mapper.UserMapper;

import lombok.Setter;

@Service
public class UserServiceImpl implements UserService{
	
	@Setter(onMethod_ = @Autowired)
	private UserMapper mapper;
	
	@Override
	public boolean join(UserDTO user) {
		return mapper.join(user) == 1;
	}
	@Override
	public boolean login(String userid, String userpw, HttpServletRequest req) {
		UserDTO loginUser = mapper.login(userid, userpw);
		if(loginUser == null) {
			return false;
		}
		else {
			if(req == null) {
				
			}else {
				req.getSession().setAttribute("loginUser", loginUser);
			}
			return true;
		}
	}
	
	@Override
	public void logout(HttpServletRequest req) {
		if(req != null) {
			req.getSession().removeAttribute("loginUser");
		}
	}
}






