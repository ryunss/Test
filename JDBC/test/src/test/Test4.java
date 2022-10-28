package test;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
	
		// 각 층마다 방이 4개씩 있는 3층짜리 빌딩의 소유주가 된 임영웅은 각 방의 월세를 입력하여 정리하려 합니다.
		// 각 호실의 월세를 입력받아 층별 총합, 층별 평균, 전체 총합, 전체 평균 을 구하는 코드를 작성하세요.
		
		Scanner sc = new Scanner(System.in);
		int[][] s = new int[3][4]; // 층, 월세
		
		for(int i=0; i<3; i++) {
			System.out.println(i+1+"층 ");
			for (int j=0; j<4; j++) {
				System.out.print(j+1+"번방 : ");
				s[i][j] = sc.nextInt();
			}
		}

		int total = 0;
		int sum = 0;
		for(int k=0; k<3; k++) {
			
			for(int i=0; i<4; i++) {
				sum += (double)s[k][i];
				total += (double)s[k][i];
			}
			System.out.println(k+1+"층의 합계금액은 "+sum+" 만원입니다");
			System.out.println(k+1+"층의  평균금액은 "+(double)(sum/4)+" 만원입니다");
			sum = 0;
		}
		System.out.println("전체 합계 금액은 "+total+" 만원입니다.");
		System.out.println("전체 평균 금액은 "+(double)(total/(4*3))+" 만원입니다.");
	}
}
