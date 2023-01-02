package com.lec.java.inner03;

public class TestOuter {
	private int value; // 1.
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	
	// 멤버 내부 클래스
	public class TestInner {
		private int value; // 2.

		public TestInner(int value) {
			this.value = value;
		}
		
		public void printValue(int value) { // 3.
			System.out.println("value = "+value); // 3번! 지역변수
			System.out.println(this.value); // 2번! 내부클래스
			System.out.println(TestOuter.this.value); // 1번! 외부클래스
		}
	
		
	} // end Inner

} // end class TestOuter














