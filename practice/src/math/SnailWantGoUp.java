package math;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SnailWantGoUp {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/math/SnailWantGoUp.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int plusMeter = sc.nextInt();
			int minusMeter = sc.nextInt();
			int height = sc.nextInt();
			int day = 0;
			int position = 0;

			while (true) {
				position += plusMeter;
				day++;
				if (position >= height) {
					break;
				}
				position -= minusMeter;
			}
 
			System.out.println(day);

		} // forTest

	}// main

}// class
