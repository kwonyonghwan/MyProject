package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PickUpCandyContest2 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/PickUpCandyContest.txt"));

		while (true) {
			int numberOfM = sc.nextInt();
			int numberOfN = sc.nextInt();
			if (numberOfM == 0 && numberOfN == 0) {
				break;
			} // ActionStop

			int[] candyBoxVerticalLine = new int[numberOfM];
			int[][] candyMap = new int[numberOfM][numberOfN];

			for (int i = 0; i < numberOfM; i++) {
				for (int j = 0; j < numberOfN; j++) {
					candyMap[i][j] = sc.nextInt();
				}
			}//forSetting

			for (int i = 0; i < numberOfM; i++) {
				candyBoxVerticalLine[i] = BottomUpMethod(candyMap[i]);
			}//LineByLineCalculate

			System.out.println(BottomUpMethod( candyBoxVerticalLine));
		}
	}// main

	public static int BottomUpMethod( int[] candyBoxLine) {

		int[] bottomUpMap = new int[candyBoxLine.length];
		
		for (int i = 0; i < bottomUpMap.length; i++) {
			if (i == 0) {
				bottomUpMap[i] = candyBoxLine[i];
				continue;
			}
			if (i == 1) {
				bottomUpMap[i] = Math.max(bottomUpMap[0], candyBoxLine[i]);
				continue;
			}
			bottomUpMap[i] = Math.max(bottomUpMap[i - 2] + candyBoxLine[i], bottomUpMap[i - 1]);
		}

		return bottomUpMap[bottomUpMap.length - 1];
	}// BottomUpMethod

}// class
