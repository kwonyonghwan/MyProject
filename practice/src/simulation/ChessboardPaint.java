package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.border.Border;

public class ChessboardPaint {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/simulation/ChessboardPaint.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfN = sc.nextInt();
		int numberOfM = sc.nextInt();
		char[][] board = new char[numberOfN][numberOfM];
		sc.nextLine();
		int minValue = Integer.MAX_VALUE;

		for (int i = 0; i < numberOfN; i++) {
			String temp = sc.nextLine();
			for (int j = 0; j < temp.length(); j++) {
				board[i][j] = temp.charAt(j);
			}
		} // forSetting

		for (int i = 0; i < numberOfN - 7; i++) {
			for (int j = 0; j < numberOfM - 7; j++) {

				int stepCountA = 0;
				int stepCountB = 0;

				boolean flag = false;

				for (int k = i; k < i + 8; k++) {
					for (int l = j; l < j + 8; l++) {

						if (!flag) {
							flag = !flag;
							if (board[k][l] == 'B') {
								stepCountA++;
							} else if (board[k][l] == 'W') {
								stepCountB++;
							}
						}

						else {
							flag = !flag;
							if (board[k][l] == 'W') {
								stepCountA++;
							} else if (board[k][l] == 'B') {
								stepCountB++;
							}
						}

					} // oneLine
					flag = !flag;
				}

				minValue = Math.min(minValue, stepCountA);
				minValue = Math.min(minValue, stepCountB);

			} // forEachStep
		}

		System.out.println(minValue);

	}// main

}// class
