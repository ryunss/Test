package test;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		// 0 ���� 100 ������ ������ ��� �Է¹޴ٰ� ������ ����� ���� �ԷµǸ� �� ��������
		// �Էµ� �ڷ��� �հ�� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// ����� �ݿø��Ͽ� �Ҽ� ù°�ڸ����� ����Ѵ�.
		// �Է¿� . 55 100 48 36 0 101 ��¿� . sum : 239 avg : 47.8
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		
		while(true)
		{
			int a = sc.nextInt();
			
			if(a>=0 && a<=100)
			{
				sum += a;
				cnt++;
			}
			else
			{
				System.out.println("sum : "+sum);
				System.out.printf("avg : %.1f",avg=(double)sum/cnt);
				break;
			}
		}
	}

}
