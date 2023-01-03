package com.koreait.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class HotelTests {
	@Autowired
	private Hotel hotel;
	
	@Test
	public void testExist() {
		log.info(hotel); // 호텔이라는 객체가 존재하는지 ? 
		log.info(hotel.getChef()); // 호텔이라는 객체안에 쉐프라는 객체가 존재하는지 ?
	}
}
