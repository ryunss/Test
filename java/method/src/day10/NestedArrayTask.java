package day10;

import java.util.Scanner;

public class NestedArrayTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�л� ���� ����� ���α׷�");
		
		String subjects[] = {"����", "����", "����"};
		
		int scores[][] = new int[4][3]; // ������ ������ �迭
		
		while(true){
			System.out.println("1. �л� ���� �Է��ϱ�");
			System.out.println("2. �л� ���� ������� ����");
			System.out.println("3. ����");
			
			int choice = sc.nextInt();
			if(choice == 1) {
				for(int i=0; i<scores.length; i++) {
					System.out.println(i+1 +"�� �л� ���� �Է�");
					for(int j=0; j<scores[i].length; j++) {
						System.out.print(subjects[j] + "���� �Է� >> ");
						scores[i][j] = sc.nextInt();
					}
					System.out.println("--------------------------");
				}
			}else if(choice == 2 ) {
				System.out.print("��� �л��� ��������� ���ðڽ��ϱ�? ");
				int sum = 0;
				int no = sc.nextInt();
				for(int i=0; i<scores[no-1].length; i++)
				{
					sum+=(double)scores[no-1][i];
				}
				System.out.println(no+"�� �л��� ��������� "+(double)(sum/subjects.length)+" �Դϴ�");
			}else if(choice == 3 ) {
				System.out.println("���α׷��� �����մϴ�");
				break;
			}else {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
			}
		}	
	}

}
