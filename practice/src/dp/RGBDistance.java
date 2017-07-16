package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RGBDistance {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/RGBDistance.txt"));
		// Scanner sc = new Scanner(System.in);

		int countOfHouse = sc.nextInt();

		int[][] RGBList = new int[countOfHouse][3];
		int[][] BottomUpMap = new int[countOfHouse][3];

		for (int i = 0; i < countOfHouse; i++) {
			for (int j = 0; j < 3; j++) {
				RGBList[i][j] = sc.nextInt();
			}
		} // forSetting
		for (int i = 0; i < 3; i++) {
			BottomUpMap[0][i] = RGBList[0][i];
		}

		for (int i = 1; i < countOfHouse; i++) {
			for (int j = 0; j < 3; j++) {
				BottomUpMap[i][j] = Math.min(BottomUpMap[i - 1][(j + 1) % 3], BottomUpMap[i - 1][(j + 2) % 3])
						+ RGBList[i][j];
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			result = Math.min(BottomUpMap[countOfHouse - 1][i], result);
		}

		System.out.println(result);

	}

}
