package com.lec.java.final01;

public class Final01Main {
	
	// final 멤버 변수
	// (주의) final 멤버 변수는 반드시 선언과 동시에 초기화 (혹은 생성자에서 초기화) 해야 한다

	final int NUM1 = 1;
//	final int NUM2; 생성자에 에러 발생.
	final int NUM3;
	
	public Final01Main() {
//		NUM1 = 10; 상수는 변경 불가능 에러.
		NUM3 = 10;
	}
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		// 지역변수는 선언이랑 초기화 따로해도 됨.
		final int num2 = 1;
		final int num3;
		num3 = 2;
		
	} // end main()

} // end class Final01Main










