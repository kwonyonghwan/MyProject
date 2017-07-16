package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lotto {

	static int[] numberList;
	static int[] combinationList = new int[7];
	static int countOfList;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/Lotto.txt"));

		// Scanner sc = new Scanner(System.in);

		countOfList = sc.nextInt() + 1;
		do {
			numberList = new int[countOfList];
			for (int i = 1; i < countOfList; i++) {
				numberList[i] = sc.nextInt();
			}

			for (int i = 1; i < countOfList - 5; i++) {
				dfs(i, 1);
			}

			System.out.println();
			countOfList = sc.nextInt() + 1;
			numberList = null;
		} while (countOfList > 1);// while

	}// main

	private static void dfs(int number, int step) {

		combinationList[step] = number;
		if (step == 6) {
			for (int i = 1; i < 7; i++) {
				System.out.print(numberList[combinationList[i]] + " ");
			}
			System.out.println();
			combinationList[step] = -1;
			return;
		} // step==6

		for (int i = number + 1; i < (countOfList - 5 + step); i++) {
			dfs(i, step + 1);
		}

		combinationList[step] = -1;

	}// dfs

}// class
