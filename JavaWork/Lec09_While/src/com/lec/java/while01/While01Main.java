package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int i = 1;
		while(i<=10) {
			System.out.println(i);
			i++;
		}
		System.out.println("while 종료 후 i = "+i);
		
		System.out.println();
		
		i = 10;
		
		while(i>=1) {
			System.out.println(i);
			i--;
		}
		System.out.println("while 종료 후 i = "+i);
		

	} // end main()
	
} // end class While01Main









