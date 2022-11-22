package com.lec.java.static02;

//클래스 변수 / 메소드 특징 (static)
//1. 메모리의 '메소드 영역'에 클래스가 로드 될때(프로그램 시작될때) '한번만' 생긴다
//2. 인스턴스가 생성되지 않아도 사용할 수 있다.
//		- 클래스이름.static변수,  클래스이름.static메소드()  <-- 요렇게 사용한다
//3. 모든 인스턴스는 하나의 static 변수/메소드를 '공유'한다.


public class Static02Main {

	public static void main(String[] args) {
		System.out.println("인스턴스 변수/메소드");
		
		Test.show2(); // 인스턴스 생성없이 사용 가능하다!	
					// Test t = new Test(); 안해도 된다는말.
		Test.sNum = 123;
		Test.show2();
		
		System.out.println("==============");
		
//		Test.num = 10; // 에러
					// 인스턴스 변수는 인스턴스를 생성해야한다!!
		
		Test t = new Test();
		t.num = 100;
		t.show();
		
		Test t2 = new Test();
		t2.show();
		
		Test.sNum = 987;
		
		System.out.println();
		t.show();
		t2.show();
		
		t2.sNum = 340; // 가능하긴 하지만 바람직한 static 사용법은 아니다.
		t.show();
		
		Test.sNum = 100;  
		t.sNum = 500;
		t2.sNum = 700;
		System.out.println(Test.sNum); // 700
		System.out.println(t.sNum); // 700
		System.out.println(t2.sNum); // 700
		
	} // end main()

} // end class Static02Main







