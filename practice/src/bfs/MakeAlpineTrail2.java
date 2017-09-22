package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
	int positionI;
	int positionJ;
	int digCount;

	public Position(int positionI, int positionJ, int dig) {
		this.positionI = positionI;
		this.positionJ = positionJ;
		this.digCount = dig;
	}
}

public class MakeAlpineTrail2 {
	static int[][] directList = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int maxResult;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/MakeAlpineTrail.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt() + 2;
			int K = sc.nextInt();
			int[][] graph = new int[N][N];
			int startPosition = 0;
			maxResult = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
						graph[i][j] = -1;
						continue;
					}
					graph[i][j] = sc.nextInt();
					if (graph[i][j] > startPosition) {
						startPosition = graph[i][j];
					}
				}
			} // forSetting
			Queue<Position> startQueue = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph[i][j] == startPosition) {
						Position temp = new Position(i, j, 0);
						startQueue.offer(temp);
					}
				}
			}

			int length = 0;
			while (!startQueue.isEmpty()) {
				boolean[][][] visitiedMap = new boolean[N][N][K+1];
				dfs(startQueue.poll(), visitiedMap, graph, K, length);
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + maxResult);
		} // forTest

	}// main

	private static void dfs(Position nowPosition, boolean[][][] visitiedMap, int[][] graph, int k, int length) {
		length++;
		maxResult = Math.max(length, maxResult);
		visitiedMap[nowPosition.positionI][nowPosition.positionJ][nowPosition.digCount] = true;

		if (nowPosition.digCount > 0) {
			// 파져있으니까 걍 갈수 있는대만
			for (int i = 0; i < 4; i++) {
				Position nextPosition = new Position(nowPosition.positionI + directList[i][0],
						nowPosition.positionJ + directList[i][1], nowPosition.digCount);
				if (graph[nextPosition.positionI][nextPosition.positionJ] > -1
						&& graph[nextPosition.positionI][nextPosition.positionJ] < graph[nowPosition.positionI][nowPosition.positionJ]
						&& !visitiedMap[nextPosition.positionI][nextPosition.positionJ][nowPosition.digCount]) {
					dfs(nextPosition, visitiedMap, graph, k, length);
				}
			}
		} else {
			// 아직 안썼으니 한번파고
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < k + 1; j++) {
					Position nextPosition = new Position(nowPosition.positionI + directList[i][0],
							nowPosition.positionJ + directList[i][1], 0);
					if (graph[nextPosition.positionI][nextPosition.positionJ] > -1
							&& (graph[nextPosition.positionI][nextPosition.positionJ] - j) < graph[nowPosition.positionI][nowPosition.positionJ]
							&& !visitiedMap[nextPosition.positionI][nextPosition.positionJ][j]	&& !visitiedMap[nextPosition.positionI][nextPosition.positionJ][0]) {
						
						graph[nextPosition.positionI][nextPosition.positionJ] -= j;
						
						nextPosition.digCount =	 j;
						dfs(nextPosition, visitiedMap, graph, k, length);
						graph[nextPosition.positionI][nextPosition.positionJ] += j;

					}
				}

			}

		} //

		visitiedMap[nowPosition.positionI][nowPosition.positionJ][nowPosition.digCount] = false;

	}// dfs

}// class
