package test;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// 정수를 계속 입력받다가 100 이상의 수가 입력이 되면 마지막 입력된 수를 포함하여 합계와 평균을 출력하는 프로그램 작성
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		
		while(true)
		{	
			int a = sc.nextInt();
			
			sum +=a;
			cnt++;
			
			if(a>=100)
			{
				avg = (double)sum/cnt;
				System.out.println(sum);
				System.out.printf("%.1f", avg);
				break;
			}
		}
	}

}
