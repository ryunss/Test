package test01;

import java.util.Scanner;

public class Main22 {

	public static void main(String[] args) {
		// 10���� ������ �Է¹޾� �Է¹��� ���� �� ¦���� ������ Ȧ���� ������ ���� ���Ͽ� ����ϴ� ���α׷� �ۼ�
		int i;
		int cnt1 = 0;
		int cnt2 = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(i=0; i<10; i++)
		{
			int a = sc.nextInt();

			if(a%2==0)
			{
				cnt1++;
			}
			else if(a%2!=0)
			{
				cnt2++;
			}
		}
		System.out.println("even : "+cnt1);
		System.out.println("odd : "+cnt2);
	}

}
