package day07;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		
		int i = 0;
		while(i < 3 ) {
			System.out.println("while�����ʹ���");
			i++;
		}
		
		System.out.println("while�� �ٱ�����");
		System.out.println("============================");
		Scanner sc = new Scanner(System.in);
	
		
		int choice = 0;
		do {
			System.out.println("1. �۱��ϱ� 2. �Ա��ϱ� 0. ����");
			choice = sc.nextInt();
		}
		while(choice != 0);
		
		
//		int choice = 0;
//		
//		System.out.println("1. �۱��ϱ� 2. �Ա��ϱ� 3. �����ϱ�");
//		choice = sc.nextInt();
//	
//		while(choice != 0) {
//			System.out.println("1. �۱��ϱ� 2. �Ա��ϱ� 3. �����ϱ�");
//			choice = sc.nextInt();		
//			}
		}
	
}
