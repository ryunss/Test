package test01;

import java.util.Scanner;

public class Main19 {

	public static void main(String[] args) {
		// 100 ������ �� ���� ������ �Է¹޾� ���� ������ ū ������ ���ʴ�� ����ϴ� ���α׷� �ۼ�
		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		int j = 0;
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		
			if(a>=b)
			{
				for(i=b; i<=a; i++)
				{
					System.out.print(i+" ");
				}
			}
			else if(b>=a)
			{
				for(j=a; j<=b; j++)
				{
					System.out.print(j+" ");
				}
			}
		
	}

}
