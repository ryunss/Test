package day11;

public class LifeCycleTest {
		// changeA 메소드 안의 a 와 main 메소드 안의 a 는 다른 값
		
	public static void main(String[] args) {
		int a = 100;
		
		LifeCycleTest.changeA(a); // 저장공간이 아니라 100 이라는 값으로 사용 된 것임.
		
		System.out.println(a); // 100 으로 출력
		
		for (int i = 0; i < 5; i++) {
			// 해당 영역에서만 i를 사용할 수 있다
		}
		
		for (int i = 0; i < 4; i++) {
			// 해당 영역에서만 i를 사용할 수 있다
		}
	}
	
	public static void changeA(int a) {
		a = 1000;
	}

}
