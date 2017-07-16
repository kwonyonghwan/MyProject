package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CountOfNumber {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/simulation/CountOfNumber.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int result = sc.nextInt() * sc.nextInt() * sc.nextInt();
			int[] countList = new int[10];
			
			do{
				countList[result%10]++;
				result = result/10;
			}while(result>10);
			
			countList[result]++;
			
			for(int i=0; i<10; i++){
				System.out.println(countList[i]);				
			}
		}//forTest
		
	}// main

}// class
