package day06;

import java.util.Scanner;

public class Review {

	public static void main(String[] args) {
		
		// target�� ����ִ� ������ �ҹ��ڶ�� �빮�ڷ� �ٲپ� ����ϰ�
		// �빮�ڶ�� �ҹ��ڷ� �ٲپ�����ϰ�
		// �� ���� ���ڶ�� �״�� ����Ͻÿ�
		
		char target = 'd';
		
		if(target >= 'a' && target <= 'z') {
			System.out.println((char)(target-32));
		}
		else if(target >= 'A' && target <= 'Z') {
			System.out.println((char)(target+32));
		}
		else /* (!(target >= 97 && target <= 122) && !(target >= 65 && target <=90)); */ 
	      	// ���� �ڵ尡 �� ������ �� �����ϱ� ������ �ȿ� ���� ���� �Ƚᵵ ��
		{
			System.out.println(target);
		}
		
		// ���� ����
		// ����ڿ��� �⵵�� �Է¹޾Ƽ� �������� �ƴ��� ����Ͻÿ�
		// 4�� ��� --> ���� : 4�� ����� �ƴ϶�� ���
		// 4�� ��� 0, 100�� ��� 0 --> ���
		// 4�� ��� 0, 100�� ��� 0, 400�� ��� 0 --> ����
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("---���� �Ǵ�---");
		System.out.print("�⵵ �Է� : ");
		
		int year = sc.nextInt();
		if(year % 4 == 0 ) {
			if(year % 100 == 0) {
				if(year % 400 == 0) {
					System.out.println("����");
				}else {
					System.out.println("���");
				}
			}else{
				System.out.println("����");
			}
		}else {
			System.out.println("���");
		}
	}		
}
