package test01;

import java.util.Scanner;

public class Main21 {

	public static void main(String[] args) {
		// 100 ������ �ڿ��� n�� �Է¹ް� n���� ������ �Է¹޾� ����� ����ϴ� ���α׷� �ۼ�.
		// (����� �ݿø��Ͽ� �Ҽ� ��°�ڸ����� ����ϵ��� �Ѵ�.)
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a = sc.nextInt();
		int sum = 0;
		double avg = 0;
		
		for(i=0; i<a; i++)
		{
			int b = sc.nextInt();
			sum+=b;
		}
		avg = (double)sum/a;
		
		System.out.printf("%.2f",avg);
		
		
	}

}
