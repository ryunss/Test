package com.lec.java.class02;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle();
		Circle c2 = new Circle(3);
		
		System.out.println();
		double perimeter = c1.calcPerimeter();
		System.out.println(perimeter);
		
		perimeter = c2.calcPerimeter();
		System.out.println(perimeter);
		
		c1.radius = 5;
		System.out.println(c1.calcArea());
		System.out.println(c1.calcPerimeter());
		
		
		System.out.println("===============");
		
		Rectangle rt = new Rectangle();
		
		rt.width = 5;
		rt.height = 2;
//		
		System.out.println(rt.a());
		System.out.println(rt.b());
		
		Rectangle rt1 = new Rectangle(5,2);
		
		
		
		
		
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










