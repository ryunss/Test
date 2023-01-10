package com.koreait.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.dto.SampleDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
//	@RequestMapping("")
//	public String basic() {
//		log.info("========basic========");
//		return "a";
//	}
	
	// localhost:9090/ex01/sample/basic1
	@RequestMapping("basic1")
	public void sajdkfhask() {
		log.info("========basic1========");
	}
	
	@GetMapping("basic")
	public void basicGet(int age) {
		log.info("========get 방식으로 요청========");
		log.info("age : "+age);
	}
	
	@PostMapping("basic")
	public void basicPost(int age) {
		log.info("========post 방식으로 요청========");
		log.info("age : "+age);
	}
	
	// value : 매핑할 URL, method : 매핑할 요청방식
	@RequestMapping(value = "basic2", method = {RequestMethod.GET, RequestMethod.POST})
	public void asic2() {
		log.info("========get, post 방식으로 요청=======");
	}
	
	//DTO 객체로 수집하기
	@GetMapping("test01")
	public String test01(SampleDTO dto) {
		log.info(dto);
		return "/sample/test01";
	}
	
	// 파라미터 명과 담을 변수명이 다른 경우 수집 방법
	@GetMapping("test02") 
	public void test02(
			@RequestParam("data1") int age,
			@RequestParam("data2")String name, 
			Model model) {
					// reqeustparam 요청된 파라미터명
					// age 라는 값을 data1으로 날린다.
		log.info(age+"/"+name);
		model.addAttribute("age", age);
		model.addAttribute("name", name);
	}
	
	// 파라미터가 같은 이름으로 여러개 날라오는 경우 수집방법 (ex. 체크박스)
	@GetMapping("test03") // data라고 날라오는 이름들을 datas 에 담고 그거를 담아서 넘긴다.
	public void test03(@RequestParam("data")String[] datas, Model model) {
		model.addAttribute("datas", datas);
	}
	
	@GetMapping("test04")
	public void test04(@RequestParam("data")ArrayList<Integer> datas, Model model) {
		model.addAttribute("datas", datas);
	}
	
	@GetMapping("test05")
	public void test05() {
		String str = null;
		str.charAt(10);
		// nullpointexception
	}
}
