package com.lec.java.file06;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*  Data Filter Stream
 Program <=== DataInputStream <=== FileInputStream <=== File
 Program ===> DataOutputStream ===> FileOutputStream ===> File

java.io.InputStream
|__ java.io.FilterInputStream
   |__ java.io.DataInputStream  

java.io.OutputStream
|__ java.io.FilterOutputStream
   |__ java.io.DataOutputStream
*/

public class File06Main {

	public static void main(String[] args) {
		System.out.println("Data Filter Stream");
		
		try(
				OutputStream out = new FileOutputStream("temp/data.bin");
				DataOutputStream dout = new DataOutputStream(out);
				
				InputStream in = new FileInputStream("temp/data.bin");
				DataInputStream din = new DataInputStream(in);
				){
			
			dout.writeBoolean(true); // 1byte
			dout.writeInt(100); // 4byte
			dout.writeDouble(3.14); // 8byte
			dout.writeChar('A'); // 2byte
								// 총 15byte. 파일열어보면 15바이트 딱 맞음.
			
			// 저장한 순서대로 읽어오기
			boolean b = din.readBoolean();
			System.out.println("boolean:" + b);
			
			int num1 = din.readInt();
			System.out.println("int: " + num1);
			
			double num2 = din.readDouble();
			System.out.println("double: "+num2);
			
			char ch = din.readChar();
			System.out.println("char : "+ch);
			
			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















