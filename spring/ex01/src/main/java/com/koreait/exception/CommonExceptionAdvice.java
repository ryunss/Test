package com.koreait.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

// 해당 클래스가 스프링의 컨트롤러에서 방샐하는 예외를 처리하는 존재임을 명시
@ControllerAdvice
@Log4j
public class CommonExceptionAdvice {
	@ExceptionHandler(Exception.class) // 예외에 대한 매핑
	public String except(Exception e, Model model) {
		log.error("===========Exception===========");
		log.error(e);
		model.addAttribute("e", e);
		return "error_page";
	}
	
	// 500 메세지는 문법 오류 발생시 @ExceptionHandler를 이용해서 처리가 가능하지만,
	// 404 메세지는 오류가 아닌 URL, URI를 잘못 호출했을 때 처리해야 한다.
	// 따라서 서블릿이 web.xml에 간 후 어디로 가야할 지 모를 때 NoHandlerFoundEcption을 발생시키도록
	// 설정을 해놓고, 실제로 매핑을 못찾았을 때 그 예외가 발생되고, 예외 발생 시
	// CommonEcptionAdvice 객체가 잡아준다. 따라서 404 메세지 대신에 원하는 페이지로
	// 응답할 수 있게 된다.
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handle404() {
		return "error_404";
	}
}
