package day11;

public class MethodTest {
	// 두 개의 정수를 더한 후 더한 결과를 출력해주는 메소드
	
	// 매개변수의 이름으로는 구분할 수가 없다.
//	public static void add(int a, int b) {
//		System.out.println("새롭게 만든 add 메소드입니다");      
//		System.out.println("a : " +a+",b : "+b);
//	}
	public static void add(int num1, int num2) {
		System.out.println("1번 실행됨");
		System.out.println(num1+num2);
	}
	
	public static void add(int num1, int num2, int num3) {
		System.out.println("2번 실행됨");
		System.out.println(num1+num2+num3);
	}
	
	public static void add(int num1, double num2) {
		System.out.println("3번 실행됨");
		System.out.println(num1+num2);
	}
	
	public static void add(double num1, int num2) {
		System.out.println("타입으로 구분하기 때문에 가능");
	}
	//리턴 타입으로는 구분할 수 없다
//	public static int f(int num1) {
//		return num1;
//	}
//	
//	public static double f(int num1) {
//		return (double)num1;
//	}
	
	public static void main(String[] args) {
//		MethodTest.f(50);
		
		MethodTest.add(20, 3.1);
		MethodTest.add(15, 20);
		MethodTest.add(20,20,20);
	}

}
