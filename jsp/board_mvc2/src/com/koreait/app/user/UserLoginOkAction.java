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
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		UserDAO udao = new UserDAO();
		if(udao.login(userid,userpw)) {
			session.setAttribute("loginUser", userid);
			//<script>
			out.print("<script>");
			//alert('apple님 어서오세요~!');
			out.print("alert('"+userid+"님 어서오세요~!');");
			//location.href = '????/board/boardlist.bo';
			out.print("location.href='"+ req.getContextPath()+"/board/boardlist.bo';");
			//</script>
			out.print("</script>");
		}
		else {
			out.print("<script>");
			out.print("alert('로그인 실패!')");
			out.print("location.href='"+ req.getContextPath()+"/';");
			out.print("</script>");
		}
		return null;
	}
}






