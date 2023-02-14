package day07;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		
		int i = 0;
		while(i < 3 ) {
			System.out.println("while문안쪽문장");
			i++;
		}
		
		System.out.println("while문 바깥문장");
		System.out.println("============================");
		Scanner sc = new Scanner(System.in);
	
		
		int choice = 0;
		do {
			System.out.println("1. 송금하기 2. 입금하기 0. 종료");
			choice = sc.nextInt();
		}
		while(choice != 0);
		
		
//		int choice = 0;
//		
//		System.out.println("1. 송금하기 2. 입금하기 3. 마감하기");
//		choice = sc.nextInt();
//	
//		while(choice != 0) {
//			System.out.println("1. 송금하기 2. 입금하기 3. 마감하기");
//			choice = sc.nextInt();		
//			}
		}
	
}
