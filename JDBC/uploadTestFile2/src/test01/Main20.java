package test01;

import java.util.Scanner;

public class Main20 {

	public static void main(String[] args) {
		// ������ �Է¹޾Ƽ� 1���� �Է¹��� ���������� 5�� ����� ���� ���Ͽ� ����ϴ� ���α׷��� �ۼ�.
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int i = 0;
		int a = sc.nextInt();
		
		for(i=1; i<=a; i++)
		{
			if(i%5==0)
			{
				sum +=i;
			}
		}
		System.out.println(sum);
	}
}
