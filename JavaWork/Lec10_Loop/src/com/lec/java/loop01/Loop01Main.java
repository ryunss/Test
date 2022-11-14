package com.lec.java.loop01;

/* break;
 * 순환문(for, while, do~while) 안에서 break를 만나면
 * break를 감싸는 가장 가까운 순환문 종료
 */
public class Loop01Main {

	public static void main(String[] args) {
		System.out.println("Break");
		
		int num = 1;
		while(num <= 10) {
			System.out.println(num);
			
			if(num==3) {
				break;
			}
			
			num++;
		}
		
		System.out.println("while 종료후 num 값은 ? "+num);
		
		
		
		System.out.println();
		// 1~100 사이에서 2와 7의 최소공배수를 출력
		// 최소공배수: 공배수 중에서 가장 작은 수

		int num1 = 1;
		
		while(num1 <= 100) {
			
			if(num1%2==0 && num1%7==0) {
				System.out.println("2와 7의 최소 공배수는 ? "+num1);
				break;
			}
			num1++;
		}
		

		System.out.println();
		System.out.println("무한 루프와 break;");

		num = 1;
		while(true) {
			System.out.println(num);
			num++;
			
			// 어떤 조건을 만족하면 무한루프를 끝내기
			if(num ==5 ) {
				break;
			}
		}
		
		
		for(num = 1;; num++) { // for 의 조건식을 비워두거나, true 이면 무한루프
			
			if(num == 5) {
				break;
			}
			System.out.println(num);
		}
		
		System.out.println();
		// 2단은 x 2 까지 출력
		// 3단은 x 3 까지 출력
		
		// TODO

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class


















