package day11;

public class LifeCycleTest {
		// changeA �޼ҵ� ���� a �� main �޼ҵ� ���� a �� �ٸ� ��
		
	public static void main(String[] args) {
		int a = 100;
		
		LifeCycleTest.changeA(a); // ��������� �ƴ϶� 100 �̶�� ������ ��� �� ����.
		
		System.out.println(a); // 100 ���� ���
		
		for (int i = 0; i < 5; i++) {
			// �ش� ���������� i�� ����� �� �ִ�
		}
		
		for (int i = 0; i < 4; i++) {
			// �ش� ���������� i�� ����� �� �ִ�
		}
	}
	
	public static void changeA(int a) {
		a = 1000;
	}

}
