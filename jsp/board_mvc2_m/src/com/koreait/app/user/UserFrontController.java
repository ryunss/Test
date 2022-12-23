package com.koreait.app.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.action.ActionTo;

public class UserFrontController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 흐름 나누기
		String requestURI = req.getRequestURI(); // /모듈/user/userjoin.us  여기서는 모듈을 / 로 설정했기 때문에 /user/userjoin.us 만 넘어옴
		String contextPath = req.getContextPath(); // /모듈명/
		String command = requestURI.substring(contextPath.length()); // /user/userjoin.us
		System.out.println("command : "+command);
		ActionTo transfer = null;
		
		switch(command) {
		case "/user/userjoin.us":
			transfer = new ActionTo();
			transfer.setPath("/app/user/joinview.jsp");
			transfer.setRedirect(false); // forward 
			break;
		case "/user/userlogin.us":
			transfer = new ActionTo();
			transfer.setPath("/app/user/loginview.jsp");
			transfer.setRedirect(false);
			break;
		case "/user/userjoinok.us":
			// 처리
			try {
				transfer = new UserJoinOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/user/userloginok.us":
			try {
				transfer = new UserLoginOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/user/checkidok.us":
			try {
				new CheckIdOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/user/userlogout.us":
			req.getSession().removeAttribute("loginUser");
			transfer = new ActionTo();
			transfer.setPath("/");
			transfer.setRedirect(false);
			break;
		}
		
		// 전송 일괄처리(어디인지, 어떤 방식인지는 몰라도 그냥 transfer라는 객체에 담겨 있는 정보를 해석해서 그대로 페이지를 이동)
		if(transfer != null) {
			if(transfer.isRedirect()) {
				resp.sendRedirect(transfer.getPath());
			}else {
				req.getRequestDispatcher(transfer.getPath()).forward(req, resp);
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
}
