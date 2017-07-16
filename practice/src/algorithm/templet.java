package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class templet {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/simulation/RobotScavenger.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " ");
		}//forTest
		
	}// main

}// class
