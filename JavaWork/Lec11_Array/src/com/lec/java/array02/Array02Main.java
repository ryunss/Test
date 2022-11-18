package com.lec.java.array02;

/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		// 1.
		int[] korean = new int[3];
		
		
		// 2.
		int[] english = new int[] { 30, 20, 30 };

		for (int i = 0; i < 3; i++) {
			System.out.println("english[" + i + "] = " + english[i]);
		}
		// 3.
		int[] math = { 99, 88, 77, 66 };

		for (int i = 0; i < 4; i++) {
			System.out.println("math[" + i + "] = " + math[i]);
		}

		// 수학점수들의 총점과 평균 계산 출력
		int sum = 0;
		for (int i = 0; i < math.length; i++) {
			sum += math[i];
		}
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (double) sum / math.length);

		// length
		int [] score = {10, 20, 30, 40, 50};
		
		System.out.println("배열의 길이 : "+score.length);
		
		int [] age = { 34, 55, 67, 12, 2, 91 };
		for (int i = 0; i < age.length; i++) {
			System.out.print(age[i]+" ");
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class Array02Main
