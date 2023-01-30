package com.koreait.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koreait.domain.UserDTO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class UserServiceTests {
	@Setter(onMethod_ = @Autowired)
	private UserService service;
	
//	@Test
//	public void joinTest() {
//		UserDTO user = new UserDTO();
//		user.setUserid("testid2");
//		user.setUserpw("testpw2");
//		user.setUsername("testname2");
//		
//		log.info("result : "+service.join(user));
//	}
	
	@Test
	public void loginTest() {
		log.info("result : "+service.login("testid2", "testpw2", null));
	}
}














