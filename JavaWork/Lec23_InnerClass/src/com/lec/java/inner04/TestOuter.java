package com.lec.java.inner04;

public class TestOuter {

	// 멤버변수
	private int value;  // 인스턴스 변수
	private static int count = 100; // 클래스 변수 (static)
	
	// 생성자
	public TestOuter(int value) {
		this.value = value;
	}
	
	// Nested class
	public static class Testnested {
		
		public void displayInfo() {
//			System.out.println(value); 스태틱이 아니라서 사용 못함
			System.out.println(count);
		}
		
		public static void println() {}
	}
	
	
} // end class TestOuter


// TestOuter: 외부 클래스(outer class, enclosing class)
// TestNested: 중첩 클래스(nested class, static inner class)








