package test;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		//�Ʒ��� ���� ���� �̸��� ����ϰ� ���ڸ� �Է¹޾� �ش��ϴ� ������ ������ ����ϴ� �۾��� �ݺ��ϴٰ�
		// �ش��ϴ� ��ȣ �̿��� ���ڰ� �ԷµǸ� "none"��� ����� �� �����ϴ� ���α׷��� �ۼ�
		// �� ������ ���� :
		// 		���ѹα� = ����(Seoul)
		//		�̱� = ������(Washington)
		//		�Ϻ� = ����(Tokyo)
		//		�߱� = �ϰ�(Beijing)
		
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("1. Korea");
			System.out.println("2. USA");
			System.out.println("3. Japan");
			System.out.println("4. China");
			System.out.print("number? ");
			int a = sc.nextInt();
			System.out.println("");
				switch(a)
				{
					case 1:
						System.out.println("Seoul");
						break;
					case 2:
						System.out.println("Washington");
						break;
					case 3:
						System.out.println("Tokyo");
						break;
					case 4:
						System.out.println("Beijing");
						break;
					default:
						System.out.println("none");
						break;
				}
			System.out.println("");
			if(a<1 || a>4)
			{
				break;
			}
		}
	}
}
