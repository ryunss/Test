package test01;

import java.util.Scanner;

public class Main13 {

	public static void main(String[] args) {
		// 100 ������ ������ �Է¹޾Ƽ� �Է¹��� �������� 100������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		int i = 0;
		int a = sc.nextInt();
		int sum = 0;
		
		for(i=0; i<=100; i++)
		{
			if(i>=a)
			{
				sum +=i;
			}
		}
		System.out.println(sum);
			
	}

}
