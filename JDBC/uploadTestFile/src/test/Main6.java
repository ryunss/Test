package test;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		// 0 이상의 정수들이 공백으로 구분되어 반복적으로 주어진다.
		// 0이 입력되면 반복문을 멈추고 그 전까지 입력받은 수들에 대하여
		// 홀수의 개수와 짝수의 개수를 출력하는 프로그램을 작성하시오.
		
		// 입력 예 / 9 7 10 5 33 65 0 출력 예 / odd : 5 even : 1
		int oddSum = 0;
		int evenSum = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			
			
			int a = sc.nextInt();
			
			if(a==0)
			{
				System.out.println("odd : "+cnt1);
				System.out.println("even : "+cnt2);
				break;
			}
			
			else if(a%2!=0)
			{
				oddSum += cnt1;
				cnt1++;
			}
			else if(a%2==0)
			{
				evenSum += cnt2;
				cnt2++;
			}
			
			
		}
	}

}
