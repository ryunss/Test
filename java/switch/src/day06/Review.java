package day06;

import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		
		// target에 들어있는 변수가 소문자라면 대문자로 바꾸어 출력하고
		// 대문자라면 소문자로 바꾸어출력하고
		// 그 외의 문자라면 그대로 출력하시오
		
		char target = 'd';
		
		if(target >= 'a' && target <= 'z') {
			System.out.println((char)(target-32));
		}
		else if(target >= 'A' && target <= 'Z') {
			System.out.println((char)(target+32));
		}
		else /* (!(target >= 97 && target <= 122) && !(target >= 65 && target <=90)); */ 
	      	// 위의 코드가 다 부정일 때 동작하기 떄문에 안에 내용 굳이 안써도 됨
		{
			System.out.println(target);
		}
		
		// 윤년 계산기
		// 사용자에게 년도를 입력받아서 윤년인지 아닌지 출력하시오
		// 4의 배수 --> 윤년 : 4의 배수가 아니라면 평년
		// 4의 배수 0, 100의 배수 0 --> 평년
		// 4의 배수 0, 100의 배수 0, 400의 배우 0 --> 윤년
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("---윤년 판단---");
		System.out.print("년도 입력 : ");
		
		int year = sc.nextInt();
		if(year % 4 == 0 ) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					System.out.println("윤년");
				}else {
					System.out.println("평년");
				}
			}else{
				System.out.println("윤년");
			}
		}else {
			System.out.println("평년");
		}
	}		
}
