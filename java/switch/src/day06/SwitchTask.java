package day06;

import java.util.Scanner;

public class SwitchTask {

	public static void main(String[] args) {
		// ����ڿ��� ���� �Է¹޾Ƽ� �ش� ���� ������ ���� ����Ͻÿ�
		// 0���� 00���� ������ �� �Դϴ�.(2�� 28�� ������ ����)
		// 1 31 2 28 3 31 4 30 5 31 6 30 7 31 8 31 9 30 10 31 11 30 12 31
		
		
//		int lastDay = 0;
		
		Scanner sc = new Scanner(System.in);
		
		// ��� 1
//		System.out.print("���� �Է��ϼ��� : ");
//		int month = sc.nextInt();
//		
//		switch(month) {
//		case 1:
//		case 3:
//		case 5:
//		case 7:
//		case 8:
//		case 10:
//		case 12:
//			lastDay = 31;
//			break;
//		case 4:
//		case 6:
//		case 9:
//		case 11:
//			lastDay = 30;
//			break;
//		case 2:
//			lastDay = 28;
//			break;
//		default:
//				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//				break;
//		}
//		
//		if(lastDay != 0) {
//			System.out.println(month + "���� " + lastDay + " ���� ������ ���Դϴ�.");
//		}
		// ------------------------------------------------------------------
		// ���2
//		switch(month) {
//		case 1:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 2:
//			System.out.println(month+"���� 28���� ������ ���Դϴ�.");
//			break;
//		case 3:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 4:
//			System.out.println(month+"���� 30���� ������ ���Դϴ�.");
//			break;
//		case 5:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 6:
//			System.out.println(month+"���� 30���� ������ ���Դϴ�.");
//			break;
//		case 7:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 8:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 9:
//			System.out.println(month+"���� 30���� ������ ���Դϴ�.");
//			break;
//		case 10:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		case 11:
//			System.out.println(month+"���� 30���� ������ ���Դϴ�.");
//			break;
//		case 12:
//			System.out.println(month+"���� 31���� ������ ���Դϴ�.");
//			break;
//		default:
//			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
//			break;
		
		
// 		========================================================
		// ��� 3 . �� ����� ������ ���� ���� �ȵ� ���� ����. Ȯ��.
		int lastDay = 0;
		
		System.out.print("���� �Է��ϼ��� : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			lastDay = 31;
			break;
		case 4, 6, 9, 11:
			lastDay = 30;
			break;
		case 2:
			lastDay = 28;
			break;
		default:
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			break;
		}
		
		if(lastDay != 0) {
			System.out.println(month + "���� " + lastDay + "���� ���������Դϴ�.");
		}

		// ����ڿ��� ������ �Է� �޾Ƽ�, ������ ����Ͻÿ�.
		// 90 �̻�, 100�� : A
		// 80 �̻� 90�� �̸� : B
		// 70 �̻� 80�� �̸� : C
		// �� �� : F
		// ����� ������ F �Դϴ�.
	
		System.out.print("���� �Է� : ");
		int score = sc.nextInt();
		
		switch(score/10) {
		case 10:
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		default:
			System.out.println("F");
			break;
		}
		
		// ������ ����Ҷ��� if�� ���°� ����. ������ �� ��ٷӱ� ����. ex) 120�� �Է�, 98.8 �Է� ��..
	}
}			

		


