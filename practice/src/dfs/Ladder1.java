package dfs;

import java.util.Scanner;
import java.util.Stack;

class Position {
	int positionI;
	int positionJ;

	public Position(int positionI, int positionJ) {
		this.positionI = positionI;
		this.positionJ = positionJ;
	}
}// position

public class Ladder1 {

	static int[][] directList = { { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int test_case;

		for (test_case = 1; test_case <= 10; test_case++) {
			int T = sc.nextInt();

			int[][] graph = new int[102][102];
			boolean[][] visitiedMap = new boolean[102][102];
			
			for (int i = 0; i < 102; i++) {
				graph[i][0] = graph[0][i] = graph[101][i] = graph[i][101] = -1;
			}

			Position startPosition = new Position(0, 0);

			for (int i = 1; i < 101; i++) {
				for (int j = 1; j < 101; j++) {
					int value = sc.nextInt();
					graph[i][j] = value;
					if (value > 1) {
						startPosition.positionI = i;
						startPosition.positionJ = j;
					}
				}
			} // forSetting

			Stack<Position> stack = new Stack<Position>();
			
			visitiedMap[startPosition.positionI][startPosition.positionJ] = true;
			stack.push(startPosition);
			
			while (!stack.isEmpty()) {
				Position nowPosition = stack.pop();
				visitiedMap[nowPosition.positionI][nowPosition.positionJ] = true;
				stack.clear();

				for (int i = 0; i < 3; i++) {
					Position nextPosition = new Position(nowPosition.positionI + directList[i][0],nowPosition.positionJ + directList[i][1]);
					
					if (nextPosition.positionI == 1) {
						System.out.println("#" + test_case + " " + (nextPosition.positionJ - 1));
						break;
					}

					if (graph[nextPosition.positionI][nextPosition.positionJ] > 0 && !visitiedMap[nextPosition.positionI][nextPosition.positionJ]) {
						stack.push(nextPosition);
					}
				} // forNextStep
				
			}//whileDFS
		} // forTest
		
	}// main
}// class
