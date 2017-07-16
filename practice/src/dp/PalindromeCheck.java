package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalindromeCheck {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/PalindromeCheck.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt() + 1;
			int[] numberList = new int[numberOfN];
			for (int i = 1; i < numberOfN; i++) {
				numberList[i] = sc.nextInt();
			}

			int[][] bottomUpMap = new int[numberOfN][numberOfN];
			int positionI = 1, positionJ = 1;
			boolean verticalDirection = false;

			for (int i = 0; i < ((2 * (numberOfN - 1)) - 1); i++) {

				if (positionI == positionJ) {
					bottomUpMap[positionI][positionJ] = 1;
				} else {
					if (numberList[positionI] == numberList[positionJ]) {
						bottomUpMap[positionI][positionJ] = 1;
					} else {
						bottomUpMap[positionI][positionJ] = 0;
					}
				}

				int tempPositionI = positionI - 1;
				int tempPositionJ = positionJ + 1;

				while (tempPositionI != 0 && tempPositionJ != bottomUpMap[0].length) {

					if (bottomUpMap[tempPositionI + 1][tempPositionJ - 1] == 0) {
						bottomUpMap[tempPositionI][tempPositionJ] = 0;
					} else {
						if (numberList[tempPositionI] == numberList[tempPositionJ]) {
							bottomUpMap[tempPositionI][tempPositionJ] = 1;
						} else {
							bottomUpMap[tempPositionI][tempPositionJ] = 0;
						}
					}

					tempPositionI--;
					tempPositionJ++;

				} // bottomUp

				if (!verticalDirection) {
					positionJ++;
					verticalDirection = true;
				} else {
					positionI++;
					verticalDirection = false;
				} // nextPosition

			} // for(2*n)-1

			int problemCount = sc.nextInt();
			for (int i = 0; i < problemCount; i++) {
				System.out.println(bottomUpMap[sc.nextInt()][sc.nextInt()]);
			}

		} // forTest

	}// main

}// class
