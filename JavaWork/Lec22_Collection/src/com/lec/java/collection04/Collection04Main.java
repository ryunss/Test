package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.List;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		List<MemberModel> list = new ArrayList<>();
		
		MemberModel mm = new MemberModel("ajdaduy", "123411");
		MemberModel mm1 = new MemberModel("ko3660", "koasdf^^");
		
		list.add(mm);
		list.add(mm1);
		
		for(MemberModel a : list) {
			System.out.println(a);
		}
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












