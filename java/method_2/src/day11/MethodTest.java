package day11;

public class MethodTest {
	// �� ���� ������ ���� �� ���� ����� ������ִ� �޼ҵ�
	
	// �Ű������� �̸����δ� ������ ���� ����.
//	public static void add(int a, int b) {
//		System.out.println("���Ӱ� ���� add �޼ҵ��Դϴ�");      
//		System.out.println("a : " +a+",b : "+b);
//	}
	public static void add(int num1, int num2) {
		System.out.println("1�� �����");
		System.out.println(num1+num2);
	}
	
	public static void add(int num1, int num2, int num3) {
		System.out.println("2�� �����");
		System.out.println(num1+num2+num3);
	}
	
	public static void add(int num1, double num2) {
		System.out.println("3�� �����");
		System.out.println(num1+num2);
	}
	
	public static void add(double num1, int num2) {
		System.out.println("Ÿ������ �����ϱ� ������ ����");
	}
	//���� Ÿ�����δ� ������ �� ����
//	public static int f(int num1) {
//		return num1;
//	}
//	
//	public static double f(int num1) {
//		return (double)num1;
//	}
	
	public static void main(String[] args) {
//		MethodTest.f(50);
		
		MethodTest.add(20, 3.1);
		MethodTest.add(15, 20);
		MethodTest.add(20,20,20);
	}

}
