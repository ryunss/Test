package test;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// ������ ��� �Է¹޴ٰ� 100 �̻��� ���� �Է��� �Ǹ� ������ �Էµ� ���� �����Ͽ� �հ�� ����� ����ϴ� ���α׷� �ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		double avg = 0;
		int cnt = 0;
		
		while(true)
		{	
			int a = sc.nextInt();
			
			sum +=a;
			cnt++;
			
			if(a>=100)
			{
				avg = (double)sum/cnt;
				System.out.println(sum);
				System.out.printf("%.1f", avg);
				break;
			}
		}
	}

}
