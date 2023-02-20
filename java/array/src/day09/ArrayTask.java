package day09;

import java.util.Scanner;

public class ArrayTask {

	public static void main(String[] args) {
		// 배열을 배열 모습으로 출력하시오.
		// {5, 4, 6, 9, 10}
		int ar[] = {5, 4, 6, 9, 10};
		
		System.out.print("{");
		for(int i=0; i<ar.length; i++) {
			if(i==(ar.length-1)) {
				System.out.print(ar[i]);
				break;
			}
			System.out.print(ar[i]+", ");
					
		}
		System.out.println("}");
			
		
		// 2. 사용자에게 국어점수, 영어점수, 수학점수를 입력받아
		// 총점과 평균을 출력하시오
		// 국어점수입력 : 90
		// 영어점수입력 : 90
		// 수학점수입력 : 90
		
		Scanner sc = new Scanner(System.in);
		int ar2[] = new int[3];
		String sub[] = {"국어", "영어", "수학"};
		int sum = 0;
		int avg = 0;
		
		for(int i=0; i<ar2.length; i++)
		{
			System.out.print(sub[i]+"점수입력 : ");
			ar2[i] = sc.nextInt();
			sum += ar2[i];
		}
		avg = sum/ar2.length;
		System.out.println("당신의 총점은 "+sum+"점, 평균은 "+avg +"점입니다.");
		// 당신의 총점은 270점, 평균은 90점 입니다.
		
	
	}

}
