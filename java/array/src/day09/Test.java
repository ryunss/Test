package day09;

public class Test {

	public static void main(String[] args) {
		char[] alphabets = {'a', 'D', '*', 'x'};
		// 4. 해당 배열을 소문자는 대문자로, 대문자는 소문자로 그 외의 문자는 그대로 담아서
		// 출력하시오.
		// 출력예시 : Ad*X
		
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
