package test01;

import java.util.Scanner;

public class Main25 {

	public static void main(String[] args) {
		// ��� ���� ���� �Է¹޾� ������ ���� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		for(int i=1; i<=a; i++)
		{
			for(int j=1; j<=b; j++)
			{
				System.out.print(j*i+" ");
				if(b==j)
				{
					System.out.println();
					
				}
			}
		}
	}
}
