package day09;

public class Test {

	public static void main(String[] args) {
		char[] alphabets = {'a', 'D', '*', 'x'};
		// 4. �ش� �迭�� �ҹ��ڴ� �빮�ڷ�, �빮�ڴ� �ҹ��ڷ� �� ���� ���ڴ� �״�� ��Ƽ�
		// ����Ͻÿ�.
		// ��¿��� : Ad*X
		
		for(int i=0; i<alphabets.length; i++) {
			
			if(alphabets[i] >= 65 && alphabets[i] <= 90)
			{
				alphabets[i] += 32;
			} else if(alphabets[i] >= 97 && alphabets[i] <= 122) {
				alphabets[i] -= 32;
			} 
			System.out.print(alphabets[i]);
		}
		
		
		System.out.println();
		String res = "";
		
		for(int i=0; i<alphabets.length; i++) {
			
			if(alphabets[i] >= 'a' && alphabets[i] <= 'z')
			{
				res += (char)(alphabets[i] - 32);
			} else if(alphabets[i] >= 'A' && alphabets[i] <= 'Z') {
				res += (char)(alphabets[i] + 32);
			} else {
				res += alphabets[i];
			}
			System.out.print(res);
		}
	}

}
