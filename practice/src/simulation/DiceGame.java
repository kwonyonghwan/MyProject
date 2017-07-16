package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/DiceGame.txt"));

		// Scanner sc = new Scanner(System.in);

		int lengthOfMap = sc.nextInt() + 1;
		int countOfStep = sc.nextInt();

		int[] gameMap = new int[lengthOfMap];

		for (int i = 1; i < lengthOfMap; i++) {
			gameMap[i] = sc.nextInt();
		}

		int totalCount = 0;
		int nowPosition = 1;
		for (int i = 0; i < countOfStep; i++) {

			int diceNumber = sc.nextInt();

			nowPosition += diceNumber;
			if (nowPosition >= (lengthOfMap - 1)) {
				System.out.println(totalCount);
				break;
			}
			
			totalCount++;
			nowPosition += gameMap[nowPosition];
			if (nowPosition >= (lengthOfMap - 1)) {
				System.out.println(totalCount);
				break;
			}

		}

	}// main

}// class
