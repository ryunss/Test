package com.koreait.service;

import javax.servlet.http.HttpServletRequest;

import com.koreait.domain.UserDTO;

public interface UserService {
	boolean join(UserDTO user);
	boolean login(String userid,String userpw, HttpServletRequest req);
	void logout(HttpServletRequest req);
}
