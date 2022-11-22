package com.lec.java.static02;

public class Test {
	
	int num; // 인스턴스 변수
	static int sNum; // 클래스 변수
	
	// 인스턴스 메소드
	public void show() {
		System.out.println("인스턴스 num = "+ num);
		System.out.println("클래스 sNum = "+ sNum);
	}
	
	// 클래스 메소드
	public static void show2() {
		// 스태틱에서 스태틱 아닌것을 사용 못한다! 17번줄
//		System.out.println("인스턴스 num = "+ num);
		System.out.println("클래스 sNum = "+ sNum);		
	}
}
