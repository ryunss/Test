package day09;

public class ArrayTest {

	public static void main(String[] args) {
		// 인덱스 번호는 0, 1, 2   배열의 길이(요소 갯수) : 3
		int scores[] = {80, 75, 35};
		
		System.out.println("배열의 길이 : "+scores.length); // 배열의 길이를 알려준다. 결과는 int 값이다
		
		System.out.println(scores);
		
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
//		System.out.println(scores[3]);  // ArrayIndexOutOfBoundsExecption 이 발생함.
//		System.out.println(scores[-1]); // 인덱스범위 벗어남
	}

}
