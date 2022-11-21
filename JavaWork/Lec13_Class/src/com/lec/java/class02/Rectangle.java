package com.lec.java.class02;

public class Rectangle {
	// 속성 : 가로, 세로
	int width;
	int height;
	
	// 생성자
	// 디폴트 생성자
	public Rectangle() {}
	
	// 매개변수를 받는 생성자
	public Rectangle(int a, int b) {
		System.out.println("넓이 : "+(a+b)*2);
		System.out.println("둘레 : "+a*b);
	}
	
	// 기능(메소드) : 사각형의 둘레
	public int a() {
		return (width+height)*2;
	}
	
	// 기능(메소드) : 사각형의 넓이
	public int b() {
		return width*height;
	}
}
