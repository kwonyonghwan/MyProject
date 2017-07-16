package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SelectNumber {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/algorithm/SelectNumber.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
		
			int countOfNumber =sc.nextInt();
			int result=0;
			
			for(int i=0; i<countOfNumber; i++){
				result = result ^ sc.nextInt();
			}//forI
			

			System.out.println("Case #" + test_case);
			System.out.println(result);
	
		}//forTest
	}//main

}//class
