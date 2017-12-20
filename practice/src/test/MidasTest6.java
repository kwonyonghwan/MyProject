package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest6 {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest5.txt"));

		 Scanner sc = new Scanner(System.in);

		int countOfApple = sc.nextInt() + 1;
		int[] appleList = new int[countOfApple];

		for (int i = 1; i < countOfApple; i++) {
			appleList[i] = sc.nextInt();
		}

		int[][] bottomUp = new int[countOfApple][countOfApple];

		for (int i = 1; i < countOfApple; i++) {
			for (int j = 1; j < countOfApple; j++) {

				bottomUp[i][j] = Math.max(bottomUp[i - 1][j], bottomUp[i][j - 1]);
				if (j >= i) {
					bottomUp[i][j] = Math.max(bottomUp[i][j], bottomUp[i][j - i] + appleList[i]);

				}

			}
		}

		System.out.println(bottomUp[countOfApple - 1][countOfApple - 1]);
	}// main

}// class
