package test01;

import java.util.Scanner;

public class Main23 {

	public static void main(String[] args) {
		// �� ���� ������ �Է¹޾� �� ���� ���� (�� ������ ����)�� 3�� ����̰ų�
		//5�� ����� ������ �հ� ����� ����ϴ� ���α׷� �ۼ�
		// (����� �ݿø��Ͽ� �Ҽ� ù°�ڸ����� ����Ѵ�.)
		
		Scanner sc = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		double avg1 = 0;
		double avg2 = 0;
		int cnt1 = 0;
		int cnt2 = 0;
		int i,j;
		
		int a = sc.nextInt();
		int b = sc.nextInt();

		if(a>=b)
		{
			for(i=b; i<=a; i++)
			{
				if(i%3==0 || i%5==0)
				{
					sum1+=i;
					cnt1++;
				}
			}
			avg1 = (double)sum1/cnt1;
			System.out.println("sum : "+sum1);
			System.out.printf("avg : %.1f\n",avg1);
		}
		else if(a<=b)
		{
			for(j=a; j<=b; j++)
			{
				if(j%3==0 || j%5==0)
				{
					sum2+=j;
					cnt2++;
				}
			}
			avg2 = (double)sum2/cnt2;
			System.out.println("sum : "+sum2);
			System.out.printf("avg : %.1f\n",avg2);
		}
		
	}

}
