package test01;

import java.util.Scanner;

public class Main23 {

	public static void main(String[] args) {
		// 두 개의 정수를 입력받아 두 정수 사이 (두 정수를 포함)에 3의 배수이거나
		//5의 배수인 수들의 합과 평균을 출력하는 프로그램 작성
		// (평균은 반올림하여 소수 첫째자리까지 출력한다.)
		
		Scanner sc = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		double avg1 = 0;
		double avg2 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int i,j;
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a>=b)
		{
			for(i=b; i<=a; i++)
			{
				if(i%3==0 || i%5==0)
				{
					sum1+=i;
					cnt1++;
				}
			}
			avg1 = (double)sum1/cnt1;
			System.out.println("sum : "+sum1);
			System.out.printf("avg : %.1f\n",avg1);
		}
		else if(a<=b)
		{
			for(j=a; j<=b; j++)
			{
				if(j%3==0 || j%5==0)
				{
					sum2+=j;
					cnt2++;
				}
			}
			avg2 = (double)sum2/cnt2;
			System.out.println("sum : "+sum2);
			System.out.printf("avg : %.1f\n",avg2);
		}
		
	}

}
