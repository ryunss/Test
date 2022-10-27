package test01;

import java.util.Scanner;

public class Main15 {

	public static void main(String[] args) {
		// 10 이하의 과목수 n이 주어진다.
		// 정수로 주어진 n개 과목의 점수를 입력받아서 실수 평균을 출력하고
		// 평균이 80점 이상이면 "pass", 80점 미만이면 "fail"이라고 출력하는 프로그램을 작성
		
		// 평균은 반올림하여 소수 첫째자리까지 출력한다.
		
		// 입력 4 , 과목 0 0 0 0  출력 : avg : 00.0 pass
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		double avg = 0;
		int sum = 0;
	
		int a = sc.nextInt();
		
		
			for(i=0; i<a; i++)
			{
				int score = sc.nextInt();
				sum +=score;
			}
		
			avg = (double)sum/a;
		
			System.out.printf("avg : %.1f\n",avg);
			
			if(avg>=80)
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		
	}

}
