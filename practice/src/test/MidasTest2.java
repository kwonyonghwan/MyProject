package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest2 {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest2.txt"));

		 Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		sc.nextLine();
		for (test_case = 1; test_case <= T; test_case++) {

			String inputString = sc.nextLine();
		
			if(inputString.equals(new StringBuilder(inputString).reverse().toString())){
				System.out.println(0);
				continue;
			}
			int result = 0;
			
			for(int i=0; i<inputString.length()/2; i++){
				result+=( Math.abs( (int)inputString.charAt(i)- (int)inputString.charAt(inputString.length()-1-i))                          );
			}
			
			System.out.println(result);
			
		}//forTestCase

	}// main

}// class
