package test01;

import java.util.Scanner;

public class Main22 {

	public static void main(String[] args) {
		// 10개의 정수를 입력받아 입력받은 수들 중 짝수의 개수와 홀수의 개수를 각각 구하여 출력하는 프로그램 작성
		int i;
		int cnt1 = 0;
		int cnt2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(i=0; i<10; i++)
		{
			int a = sc.nextInt();

			if(a%2==0)
			{
				cnt1++;
			}
			else if(a%2!=0)
			{
				cnt2++;
			}
		}
		System.out.println("even : "+cnt1);
		System.out.println("odd : "+cnt2);
	}

}
