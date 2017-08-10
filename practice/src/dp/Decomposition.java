package dp;

import java.util.Scanner;

public class Decomposition {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// int numberOfN = sc.nextInt();
		// int numberOfK = sc.nextInt();
		int numberOfN = 20;
		int numberOfK = 2;

		int[][] bottomUpMap = new int[numberOfK + 1][numberOfN + 1];

		for (int i = 1; i < numberOfK + 1; i++) {
			bottomUpMap[i][0] = 1;
		}

		for (int i = 1; i < numberOfK + 1; i++) {
			for (int j = 1; j < numberOfN + 1; j++) {
				bottomUpMap[i][j] = (bottomUpMap[i][j - 1] + bottomUpMap[i - 1][j]) % 1000000000;
			}
		} // MakeForBottomUP

		System.out.println(bottomUpMap[numberOfK][numberOfN]);
	}// main

}// class
