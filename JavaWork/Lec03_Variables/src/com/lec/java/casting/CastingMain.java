package com.lec.java.casting;

public class CastingMain {
	 /* 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
	 * 
	 * 		primitive type 에서 implicit casting 방향
	 * 
	 * 		byte → short → int → long → float → double  
	 *                 		↑
	 *                    char
	 * 
	 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
	 *      
	 *      (변환하고자 하는 타입명)변수/값
*/
	public static void main(String[] args) {
		byte num1 = 123; // 대입시 자동 형변환
		short s1 = 123;
		int n1 = s1; // int <- short
		double d1 = n1; // double <- int
		
		char ch1 = 'A';
//		s1 = ch1; // ch는 short 로 형변환 되지 않는다. int 타입으로만 가능
		n1 = ch1; // int <- char
		
		// 명시적 형변환 : 코드상에서 직접 타입 변환
		byte num5 = (byte)513; // 0010 0000 0001 -> byte => 8bit => 0000 0001 =>
								// 그래서 출력값은 1이 나오게 됨.
		System.out.println("num5 = "+num5); // 주의! 자료 손실 발생 위험있음.
		
		int n = 10;
//		byte num6 = n;
		byte num6 = (byte)n;
		
		double avg1 = (99 + 88 + 78) / 3;    // 88.0 <- 88
		double avg2 = (double)(99 + 88 + 78) / 3;
		System.out.println("avg1 = " + avg1);
		System.out.println("avg2 = " + avg2);
	}

}
