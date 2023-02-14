package day07;

public class IncrementalOperator {

	public static void main(String[] args) {
		// 전위형 : 우선순위가 매우 빠르다
		int a = 10;
		++a; // a = a+1;
		System.out.println(a); // a는 11 이 저장되어있음
		System.out.println(++a); // 12
		// 후위형 : 우선순위가 매우 느리다(대입연산자보다도 느리다)
		int b = 10;
		b++; // b = b+1;
		System.out.println(b); // b에는 11 이 저장되어있음
		System.out.println(b++); // 11
		System.out.println(b); // 12
		
		int num1 = 10;
		int num2 = num1++;
		System.out.println("-------------");
		System.out.println(++num1); // 12
		System.out.println(num2); // 10
		
	}

}
