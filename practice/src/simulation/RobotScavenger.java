package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.sound.sampled.Port;

public class RobotScavenger {

	static int[][] directionMove = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/RobotScavenger.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt();
			int numberOfM = sc.nextInt();
			int positionR = sc.nextInt();
			int positionC = sc.nextInt();
			int direction = sc.nextInt();
			int[][] robotScavengerMap = new int[numberOfN][numberOfM];
			int cleanCount = 1;

			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfM; j++) {
					robotScavengerMap[i][j] = sc.nextInt();
				}
			} // forSetting

			robotScavengerMap[positionR][positionC] = 2;

			while (robotScavengerMap[positionR + directionMove[0][0]][positionC + directionMove[0][1]] < 1
					|| robotScavengerMap[positionR + directionMove[1][0]][positionC + directionMove[1][1]] < 1
					|| robotScavengerMap[positionR + directionMove[2][0]][positionC + directionMove[2][1]] < 1
					|| robotScavengerMap[positionR + directionMove[3][0]][positionC + directionMove[3][1]] < 1
					|| robotScavengerMap[positionR + directionMove[(direction + 2) % 4][0]][positionC + directionMove[(direction + 2) % 4][1]] != 1) {

				boolean dontGoAnyWhere = true;
				int directionCount = 0;

				if (robotScavengerMap[positionR][positionC] == 0) {
					cleanCount++;
					robotScavengerMap[positionR][positionC] = 2;
				} // Action1

				for (int i = 3; i > -1; i--) {
					if (robotScavengerMap[positionR + directionMove[(direction + i) % 4][0]][positionC + directionMove[(direction + i) % 4][1]] < 1) {
						dontGoAnyWhere = false;
						direction = (direction + i) % 4;
						positionR = positionR + directionMove[direction][0];
						positionC = positionC + directionMove[direction][1];
						break;
					} // Action 2-1	
				} // forAction2-1,2-2
				
				if (dontGoAnyWhere) {
					positionR += directionMove[(direction + 2) % 4][0];
					positionC += directionMove[(direction + 2) % 4][1];
				} // Action2-3

			} // whileForAction2-4

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + cleanCount);

		} // forTest

	}// main

}// class