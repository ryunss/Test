package test01;

import java.util.Scanner;

public class Main14 {

	public static void main(String[] args) {
		// 10개의 정수를 입력받아 3의 배수의 개수와 5의 배수의 개수를 각각 출력하는 프로그램을 작성하시오
		
		Scanner sc = new Scanner(System.in);
		
		int cnt1 = 0;
		int cnt2 = 0;
		int i = 0;
		
		while(i<10)
		{
			int a = sc.nextInt();
			
			if(a%3==0)
			{
				cnt1++;
			}
		
			if(a%5==0)
			{
				cnt2++;
			}
			i++;
		}
		System.out.println("Multiples of 3 : "+cnt1);	
		System.out.println("Multiples of 5 : "+cnt2);
	}

}
