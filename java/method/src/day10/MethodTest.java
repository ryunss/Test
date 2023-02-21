package day10;

public class MethodTest {

	public static void main(String[] args) {
		
		System.out.println("==============================");
		MethodTest.printName("김철수", 3);
		System.out.println("개발중");
		MethodTest.printName("홍길동", 4);
		
		System.out.println(MethodTest.add(10,20) / 2);
	     //MethodTest.add(10,20) 이 30 으로 값으로 보이기때문에 나누기 연산 가능함
	}

	public static void printName(String name, int cnt) { 
		                     // 괄호 안 이름 (String name) = 매개변수, 인자
		         // 리턴 옆에 있는 값의 타입을 말함. 즉, void 리턴값이 없음
		for(int i=0; i<cnt; i++) {
			System.out.println(name);
		}
		System.out.println("---------------");
	}
	
	//두 정수를 더해주는 메소드
	public static int add(int num1, int num2) {
		         // 리턴 옆에 있는 값의 타입을 말함. 즉, int 리턴값이 있음.
		return num1 + num2;
	}
}
