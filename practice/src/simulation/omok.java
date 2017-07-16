package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class omok {

	static int[][] omokMap;
	static int sizeOfMap = 20;
	static boolean endingSignal;
	static int[][] directionList = { { 0, 1 }, { 1, 0 }, { -1, 1 }, { 1, 1 } };

	public static void main(String[] args) throws FileNotFoundException {
		omokMap = new int[sizeOfMap][sizeOfMap];

		Scanner sc = new Scanner(new FileInputStream("src/simulation/omok.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			endingSignal = true;
			for (int i = 0; i < sizeOfMap; i++) {
				for (int j = 0; j < sizeOfMap; j++) {
					omokMap[i][j] = -1;
				}
			}

			int stepOfGame = sc.nextInt();
			int countOfStep = 0;
			boolean odd = true;

			for (int i = 0; i < stepOfGame; i++) {
				if (endingSignal) {
					countOfStep++;
					gameStep(sc.nextInt(), sc.nextInt(), odd);
					odd = !odd;
				} else {
					System.out.println(countOfStep);
					break;
				}
			}

			if(endingSignal){
				System.out.println(-1);
			}
			
			
		} // forTest
	}// main

	public static void gameStep(int positionI, int positionJ, boolean odd) {
		if (odd) {
			omokMap[positionI][positionJ] = 0;
		} else {
			omokMap[positionI][positionJ] = 1;
		}

		for (int k = 0; k < 4; k++) {
			checkEndsignal(positionI, positionJ, k);
		}
	}// gameStep

	public static void checkEndsignal(int positionI, int positionJ, int caseNumber) {

		boolean[][] visitedMap = new boolean[sizeOfMap][sizeOfMap];
		Position startPosition = new Position(positionI, positionJ);

		Queue<Position> queue = new LinkedList<Position>();
		visitedMap[startPosition.positionI][startPosition.positionJ] = true;
		queue.offer(startPosition);
		int count = 1;
		while (!queue.isEmpty()) {

			Position tempPosition = queue.poll();

			if (tempPosition.positionI + directionList[caseNumber][0] > 0
					&& tempPosition.positionJ + directionList[caseNumber][1] > 0
					&& tempPosition.positionI + directionList[caseNumber][0] < 20
					&& tempPosition.positionJ + directionList[caseNumber][1] < 20
					&& omokMap[tempPosition.positionI][tempPosition.positionJ] == omokMap[tempPosition.positionI
							+ directionList[caseNumber][0]][tempPosition.positionJ + directionList[caseNumber][1]]
					&& !visitedMap[tempPosition.positionI + directionList[caseNumber][0]][tempPosition.positionJ
							+ directionList[caseNumber][1]]) {

				Position nextPosition = new Position(tempPosition.positionI + directionList[caseNumber][0],
						tempPosition.positionJ + directionList[caseNumber][1]);
				visitedMap[tempPosition.positionI + directionList[caseNumber][0]][tempPosition.positionJ
						+ directionList[caseNumber][1]] = true;
				count++;
				queue.offer(nextPosition);

			}

			if (tempPosition.positionI - directionList[caseNumber][0] > 0
					&& tempPosition.positionJ - directionList[caseNumber][1] > 0
					&& tempPosition.positionI - directionList[caseNumber][0] < 20
					&& tempPosition.positionJ - directionList[caseNumber][1] < 20
					&& omokMap[tempPosition.positionI][tempPosition.positionJ] == omokMap[tempPosition.positionI
							- directionList[caseNumber][0]][tempPosition.positionJ - directionList[caseNumber][1]]
					&& !visitedMap[tempPosition.positionI - directionList[caseNumber][0]][tempPosition.positionJ
							- directionList[caseNumber][1]]) {

				Position nextPosition = new Position(tempPosition.positionI - directionList[caseNumber][0],
						tempPosition.positionJ - directionList[caseNumber][1]);
				visitedMap[tempPosition.positionI - directionList[caseNumber][0]][tempPosition.positionJ
						- directionList[caseNumber][1]] = true;
				count++;
				queue.offer(nextPosition);

			}

		} // whileBFS

		if (count == 5) {
			endingSignal = false;
		}

	}// checkEndSignal

}//

class Position {
	int positionI;
	int positionJ;

	public Position(int i, int j) {
		this.positionI = i;
		this.positionJ = j;
	}

}
