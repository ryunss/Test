package com.koreait.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class B extends HttpServlet{

	private static final long serialVersionUID = 1L;

	// 입력 -> 데이터전송 -> 데이터수집 -> 데이터처리 -> 결과데이터 전송응답 -> 결과데이터 출력  
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 수집
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		
		//처리
		
		//DB 처리
		int result = num1 + num2;
		
		//결과데이터 전송
		req.setAttribute("result", result);
		req.getRequestDispatcher("c.jsp").forward(req, resp);
	}
}
