package test;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		// �ﰢ���� �غ��� ���̿� ���̸� �Է¹޾� ���̸� ����ϰ�,
		// "Continue? "���� �ϳ��� ���ڸ� �Է¹޾� �� ���ڰ� 'Y' �� 'y' �̸�
		// �۾��� �ݺ��ϰ� �ٸ� �����̸� �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
		// (���̴� �ݿø��Ͽ� �Ҽ� ù°�ڸ����� ����Ѵ�.)
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("Base = ");
			int base = sc.nextInt();
			System.out.print("Height = ");
			int height = sc.nextInt();
			System.out.printf("Triangle width = %.1f\n",((double)base*height/2));	
			System.out.print("Continue? ");
			
			String con = sc.next();
			
			if(con.equals("Y") || con.equals("y"))
			{
				continue;
			}
			else
			{
				break;
			}
		}
	}

}
