package test01;

import java.util.Scanner;

public class Main15 {

	public static void main(String[] args) {
		// 10 ������ ����� n�� �־�����.
		// ������ �־��� n�� ������ ������ �Է¹޾Ƽ� �Ǽ� ����� ����ϰ�
		// ����� 80�� �̻��̸� "pass", 80�� �̸��̸� "fail"�̶�� ����ϴ� ���α׷��� �ۼ�
		
		// ����� �ݿø��Ͽ� �Ҽ� ù°�ڸ����� ����Ѵ�.
		
		// �Է� 4 , ���� 0 0 0 0  ��� : avg : 00.0 pass
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		double avg = 0;
		int sum = 0;
	
		int a = sc.nextInt();
		
		
			for(i=0; i<a; i++)
			{
				int score = sc.nextInt();
				sum +=score;
			}
		
			avg = (double)sum/a;
		
			System.out.printf("avg : %.1f\n",avg);
			
			if(avg>=80)
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
		
	}

}
