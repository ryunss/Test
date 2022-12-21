package com.koreait.app.user;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.action.Action;
import com.koreait.action.ActionTo;
import com.koreait.dao.UserDAO;

public class UserLoginOkAction implements Action {

	@Override
	public ActionTo execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String userid = req.getParameter("userid");
		String userpw = req.getParameter("userpw");
		
		HttpSession session = req.getSession();
		
		resp.setCharacterEncoding("UTF-8"); // 2. utf-8 설정해주고,
		resp.setContentType("text/html; charset=utf-8"); // 3. html로 설정해준다.
		PrintWriter out = resp.getWriter(); // 1. 글로 써서 보내야하는데
											// 위 3가지를 하는 이유가 29번째줄 처럼 이 페이지 자체에서 스크립트로 alert 띄우기 위함.
		UserDAO udao = new UserDAO();
		if(udao.login(userid, userpw)) {
			session.setAttribute("loginUser", userid);
			out.print("<script>alert('"+userid+"님 어서오세요~'); location.href='"
					+ req.getContextPath()+"/board/boardlist.bo';</script>");
			// location.href = '????/board/boardlist.bo';</script>
		}else {
			out.print("<script>alert('로그인 실패!'); location.href='"
					+ req.getContextPath()+"/';</script>");
		}
		return null; // 어차피 29번째줄, 31번쨰줄에서 location 하기 때문에 transfer 객체를 만들 필요도 없다.
	}
}
