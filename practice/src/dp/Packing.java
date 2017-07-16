package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Packing {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Packing.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			
			int numberOfObject = sc.nextInt() + 1;
			int volumeOfCarrier = sc.nextInt() + 1;
			
			String[] nameOfObject = new String[numberOfObject];
			int[] volumeOfObject = new int[numberOfObject];
			int[] hopePercentOfObject = new int[numberOfObject];

			for (int i = 1; i < numberOfObject; i++) {
				nameOfObject[i] = sc.next();
				volumeOfObject[i] = sc.nextInt();
				hopePercentOfObject[i] = sc.nextInt();
			}//setting

			int[][] bottomUpPacking = new int[numberOfObject][volumeOfCarrier];

			for (int i = 0; i < numberOfObject; i++) {
				for (int j = 0; j < volumeOfCarrier; j++) {
					if (i == 0) {
						bottomUpPacking[i][j] = 0;
						continue;
					}
					if (volumeOfObject[i] > j) {
						bottomUpPacking[i][j] = bottomUpPacking[i - 1][j];
						continue;
					}
					bottomUpPacking[i][j] = Math.max(bottomUpPacking[i - 1][j], hopePercentOfObject[i] + bottomUpPacking[i - 1][j - volumeOfObject[i]]);

				} // forVolumeOfCarrier
			} // forNumberOfObject
			
			for(int i=0; i<numberOfObject; i++){
				for(int j=0; j<volumeOfCarrier; j++){
					System.out.format("%3d", bottomUpPacking[i][j]); 
				}
				System.out.println();
			}
			

			int tempI = numberOfObject - 1;
			int tempJ = volumeOfCarrier - 1;
			ArrayList<String> resultList = new ArrayList<String>();

			for (int i = tempI; i > -1; i--) {
				if (bottomUpPacking[i][tempJ] != bottomUpPacking[i - 1][tempJ]) {
					resultList.add(nameOfObject[i]);
					tempI = i - 1;
					tempJ -= volumeOfObject[i];
					if (tempI == 0) {
						break;
					}
				}
			}

			System.out.println("Case #" + test_case);
			System.out.println(bottomUpPacking[numberOfObject - 1][volumeOfCarrier - 1] + " " + resultList.size());
			System.out.println(resultList.toString());

		} // forTestSase

	}// main

}// class

