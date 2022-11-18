package com.lec.java.array13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* java.util.Arrays 클래스
     배열을 다루는 유용한 메소드들 제공
		Arrays.toString() : 문자열 형태로 리턴
		Arrays.copyOf(원본배열, 복사할 length)
		Arrays.copyOfRange(원본배열, from, to)) : from 부터 to 직전까지 복사
		Arrays.fill()  : 배열에 특정 값으로 채우기
		Arrys.sort(원본배열) :  오름차순 변경
		Arrays.asList() : array -> List 로
 */
public class Array13Main {

	public static void main(String[] args) {
		System.out.println("java.util.Arrays 클래스");
	
		int[] arr = {10, 20, 30, 40, 50};
		
		System.out.println(Arrays.toString(arr));
		
		int [] arr7 = { 8, 9, 3, 5, 1, 2};
		
		System.out.println(Arrays.toString(arr7));
		Arrays.sort(arr7); // 오름차순 정렬 1,2,3,4,5,6,7 ... 순서
		System.out.println(Arrays.toString(arr7));
		
		int [] arr2 = Arrays.copyOf(arr,  3); // arr7 에서 앞에서 3개 복사해서 저장
		System.out.println(Arrays.toString(arr2));
		
		int [] arr4 = Arrays.copyOfRange(arr, 0, 2); // arr 에서 0부터 2 직전까지 복사 (2는 포함하지 않는다는것이 중요!)
		
		System.out.println(Arrays.toString(arr4)); // 10 20 출력됨.
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class
