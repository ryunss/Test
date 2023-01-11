package com.koreait.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Log4j
@WebAppConfiguration
public class UserControllerTests {
	@Setter(onMethod_ = @Autowired)
	private WebApplicationContext wac;
	
	// 가짜 MVC
	// 마치 브라우저에서 사용하는 것처럼 만들어서 Controller를 실행해 볼 수 있다.
	private MockMvc mvc;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
//	@Test
//	public void replaceTest() throws Exception {
//						// 가짜 Mvc에 요청을 만든다.	get방식으로 user/join으로 보낸다.
//		//ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/user/join"))
//		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.get("/user/login"))
//			.andReturn()
//			.getModelAndView();
//		
//		log.info(mav.getViewName());
//		log.info(mav.getModelMap());
//	}
	
//	@Test
//	public void joinTest() throws Exception{
//		// 								요청제작자				post 방식으로 /user/join 으로 보낸다
//		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/user/join")
//				.param("userid", "testid3") // 요청을 보낼 때 파라미터를 추가해서 요청 보내기
//				.param("userpw", "testpw3")
//				.param("username", "testname3")				
//				)
//			.andReturn() // 반환된 결과 : 응답(뷰, 모델 등을 포함)
//			.getModelAndView(); // 응답에서 모델과 뷰를 포함하고 있는 타입의 객체 받기
//		
//		log.info(mav.getViewName());
//		log.info(mav.getModelMap());
//	}
	
	@Test
	public void loginTest() throws Exception{
		ModelAndView mav = mvc.perform(MockMvcRequestBuilders.post("/user/login")
				.param("userid", "testid3")
				.param("userpw", "testpw3")				
				)
			.andReturn()
			.getModelAndView();
		
		log.info(mav.getViewName());
		log.info(mav.getModelMap());
	}
}
