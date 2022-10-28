package test;

import java.util.Scanner;

public class Test3 {
	public static void main(String[] args) {
		// 총 10개의 정수를 입력받아 최대값과 최소값을 구하는 코드를 작성하세요
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 10개를 입력하세요 ");
		int[] d = new int[10];
		int len = d.length;
		int max= 0;
		
		for (int i = 0; i < len; i++) {
			System.out.print("입력 "+(i+1)+" : ");
			d[i] = sc.nextInt();
		}
		int min = d[0];
		
		for (int i = 0; i < len; i++) {
			if(d[i] < min){
				min = d[i];
			}
			if(d[i] > max) {
				max = d[i];
			}
		}
		
		System.out.println("max = "+max);
		System.out.println("min = "+min);
	

		
	}
}	
