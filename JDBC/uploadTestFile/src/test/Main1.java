package test;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		// �� ���� ������ �Է¹޾� ������� �������� ����ϴ� �۾��� �ݺ��ϴٰ� 0 �� �ԷµǸ� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("number? ");

			int a = sc.nextInt();
			
			if(a>0)
			{
				System.out.println("positive integer");
			}
			else if(a<0)
			{
				System.out.println("negative number");
			}
			else if(a==0)
			{
				break;
			}
		}
		
	}

}
