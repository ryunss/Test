package test;

import java.util.Scanner;

public class View {
	Scanner sc = new Scanner(System.in);

	void joinview() {
		System.out.print("게시글 내용을 입력하세요 : ");
		String content = sc.nextLine();
	}
}
