package day09;

public class ArrayTest {

	public static void main(String[] args) {
		// �ε��� ��ȣ�� 0, 1, 2   �迭�� ����(��� ����) : 3
		int scores[] = {80, 75, 35};
		
		System.out.println("�迭�� ���� : "+scores.length); // �迭�� ���̸� �˷��ش�. ����� int ���̴�
		
		System.out.println(scores);
		
		for(int i=0; i<scores.length; i++) {
			System.out.println(scores[i]);
		}
		
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
//		System.out.println(scores[3]);  // ArrayIndexOutOfBoundsExecption �� �߻���.
//		System.out.println(scores[-1]); // �ε������� ���
	}

}
