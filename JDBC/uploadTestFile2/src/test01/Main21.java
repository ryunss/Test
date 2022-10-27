package test01;

import java.util.Scanner;

public class Main21 {

	public static void main(String[] args) {
		// 100 이하의 자연수 n을 입력받고 n개의 정수를 입력받아 평균을 출력하는 프로그램 작성.
		// (평균은 반올림하여 소수 둘째자리까지 출력하도록 한다.)
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a = sc.nextInt();
		int sum = 0;
		double avg = 0;
		
		for(i=0; i<a; i++)
		{
			int b = sc.nextInt();
			sum+=b;
		}
		avg = (double)sum/a;
		
		System.out.printf("%.2f",avg);
		
		
	}

}
