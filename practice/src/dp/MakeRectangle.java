package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeRectangle {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/MakeRectangle.txt"));

		// Scanner sc = new Scanner(System.in);

		int countOfNumber = sc.nextInt() + 1;// sc.nextInt();
		int[] stickList = new int[countOfNumber];
		int maxResult = -1;

		for (int i = 1; i < countOfNumber; i++) {
			stickList[i] = sc.nextInt();
		} // forSetting

		int[][] bottomUpMap = new int[countOfNumber][countOfNumber];

		for (int i = 1; i < countOfNumber; i++) {
			for (int j = i; j < countOfNumber; j++) {
				bottomUpMap[i][j] = bottomUpMap[i][j - 1] + stickList[j];
			}
		} // forSetting

		for (int i = 0; i < countOfNumber; i++) {
			for (int j = 0; j < countOfNumber; j++) {

				System.out.print(bottomUpMap[i][j] + "  ");
			}
			System.out.println();
		}

		for (int i = 1; i < countOfNumber - 3; i++) {
			for (int j = i + 1; j < countOfNumber - 2; j++) {
				for (int k = j + 1; k < countOfNumber - 1; k++) {
					if (bottomUpMap[1][i] == bottomUpMap[j + 1][k]
							&& bottomUpMap[i + 1][j] == bottomUpMap[k + 1][countOfNumber - 1]) {
						maxResult = Math.max(maxResult, (bottomUpMap[1][i] * bottomUpMap[i + 1][j]));
					}
					if (bottomUpMap[1][i] == bottomUpMap[i + 1][j]
							&& bottomUpMap[j + 1][k] == bottomUpMap[k + 1][countOfNumber - 1]) {
						maxResult = Math.max(maxResult, (bottomUpMap[1][i] * bottomUpMap[j + 1][k]));
					}
					if (bottomUpMap[i + 1][j] == bottomUpMap[j + 1][k]
							&& bottomUpMap[1][i] == bottomUpMap[k + 1][countOfNumber - 1]) {
						maxResult = Math.max(maxResult, (bottomUpMap[1][i] * bottomUpMap[i + 1][j]));
					}

				}
			}
		}

		System.out.println(maxResult);
	}// main

}// class
