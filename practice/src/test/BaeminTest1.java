package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import dp.Sticker;

public class BaeminTest1 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner s = new Scanner(new FileInputStream("src/test/BaeminTest1.txt"));

		// Scanner sc = new Scanner(System.in);

		int n = s.nextInt();
		int d = s.nextInt();
		int k = s.nextInt();
		int j = s.nextInt();

		boolean[] peopleArray = new boolean[n + 1];
		int Index = 1;

		for (int step = 0; step < n - 1; step++) {

			// ÀÌµ¿
			int temp = 0;
			while (temp < k) {
				if (d == 1) {
					Index++;
					if (Index > n) {
						Index = 1;
					}
				}

				if (d == 0) {
					Index--;
					if (Index < 1) {
						Index = n;
					}
				}
				if (!peopleArray[Index]) {
					temp++;
				}

			} // whileOneStep
			System.out.println(Index);
			peopleArray[Index] = true;
			k += j;

		}

		// search people
		for (int i = 1; i < peopleArray.length; i++) {
			if (!peopleArray[i]) {
				System.out.println(i);
			}
		}

	}// main

}// class
