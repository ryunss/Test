package day10;

public class MethodTest {

	public static void main(String[] args) {
		
		System.out.println("==============================");
		MethodTest.printName("��ö��", 3);
		System.out.println("������");
		MethodTest.printName("ȫ�浿", 4);
		
		System.out.println(MethodTest.add(10,20) / 2);
	     //MethodTest.add(10,20) �� 30 ���� ������ ���̱⶧���� ������ ���� ������
	}

	public static void printName(String name, int cnt) { 
		                     // ��ȣ �� �̸� (String name) = �Ű�����, ����
		         // ���� ���� �ִ� ���� Ÿ���� ����. ��, void ���ϰ��� ����
		for(int i=0; i<cnt; i++) {
			System.out.println(name);
		}
		System.out.println("---------------");
	}
	
	//�� ������ �����ִ� �޼ҵ�
	public static int add(int num1, int num2) {
		         // ���� ���� �ִ� ���� Ÿ���� ����. ��, int ���ϰ��� ����.
		return num1 + num2;
	}
}
