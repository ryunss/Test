package day07;

public class IncrementalOperator {

	public static void main(String[] args) {
		// ������ : �켱������ �ſ� ������
		int a = 10;
		++a; // a = a+1;
		System.out.println(a); // a�� 11 �� ����Ǿ�����
		System.out.println(++a); // 12
		// ������ : �켱������ �ſ� ������(���Կ����ں��ٵ� ������)
		int b = 10;
		b++; // b = b+1;
		System.out.println(b); // b���� 11 �� ����Ǿ�����
		System.out.println(b++); // 11
		System.out.println(b); // 12
		
		int num1 = 10;
		int num2 = num1++;
		System.out.println("-------------");
		System.out.println(++num1); // 12
		System.out.println(num2); // 10
		
	}

}
