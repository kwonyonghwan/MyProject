package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PickUpCandyContest {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dp/PickUpCandyContest.txt"));

		while (true) {
			int numberOfM = sc.nextInt();
			int numberOfN = sc.nextInt();
			if (numberOfM == 0 && numberOfN == 0) {
				break;
			} // ActionStop

			int[] candyBoxVerticalLine = new int[numberOfM];

			for (int i = 0; i < numberOfM; i++) {
				int[] bottomUpMap = new int[numberOfN];

				for (int j = 0; j < numberOfN; j++) {
					if (j == 0) {
						bottomUpMap[j] = sc.nextInt();
						continue;
					}
					if (j == 1) {
						bottomUpMap[j] = Math.max(bottomUpMap[0], sc.nextInt());
						continue;
					}
					bottomUpMap[j] = Math.max(bottomUpMap[j - 2] + sc.nextInt(), bottomUpMap[j - 1]);
				}
				
				candyBoxVerticalLine[i] = bottomUpMap[bottomUpMap.length - 1];
				bottomUpMap = null;
			}

			int[] bottomUpMap = new int[numberOfM];

			for (int i = 0; i < numberOfM; i++) {
				if (i == 0) {
					bottomUpMap[i] = candyBoxVerticalLine[i];
					continue;
				}

				if (i == 1) {
					bottomUpMap[i] = Math.max(bottomUpMap[0], candyBoxVerticalLine[i]);
					continue;
				}
				bottomUpMap[i] = Math.max(bottomUpMap[i - 2] + candyBoxVerticalLine[i], bottomUpMap[i - 1]);
			}

			System.out.println(bottomUpMap[bottomUpMap.length - 1]);
		}
	}// main

}// class
