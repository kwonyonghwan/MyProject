package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GreedPanda {
	static int resultServivalDay;
	static int stepServivalDay;
	static int[][] directionList = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };
	static int[][] memoization;
	static int count = 0;;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/GreedPanda.txt"));

		// Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int graphLength = Integer.parseInt(st.nextToken());
		int[][] graph = new int[graphLength][graphLength];
		memoization = new int[graphLength][graphLength];
		boolean[][] visitiedGraph = new boolean[graphLength][graphLength];

		for (int i = 0; i < graphLength; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < graphLength; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < graphLength; i++) {
			for (int j = 0; j < graphLength; j++) {
				stepServivalDay = 0;
				dfs(i, j, 0, graph, visitiedGraph);
				memoization[i][j] = stepServivalDay;
				resultServivalDay = Math.max(resultServivalDay, memoization[i][j]);
			}
		}

		// 이 부분에서 정답을 출력하십시오.
		System.out.println("dsdf" + resultServivalDay);
		System.out.println(count);

	}// main

	private static void dfs(int positionI, int positionJ, int servivalDay, int[][] graph, boolean[][] visitiedGraph) {
		count++;
		visitiedGraph[positionI][positionJ] = true;
		servivalDay++;

		for (int i = 0; i < 4; i++) {
			int nextPositionI = positionI + directionList[i][0];
			int nextPositionJ = positionJ + directionList[i][1];

			if (nextPositionI > -1 && nextPositionI < graph.length && nextPositionJ > -1
					&& nextPositionJ < graph[0].length && !visitiedGraph[nextPositionI][nextPositionJ]) {

				if (graph[nextPositionI][nextPositionJ] > graph[positionI][positionJ]) {

					if (memoization[nextPositionI][nextPositionJ] > 0) {
						stepServivalDay = Math.max(servivalDay + memoization[nextPositionI][nextPositionJ],
								stepServivalDay);
						continue;
					} // checkMemoization

					dfs(nextPositionI, nextPositionJ, servivalDay, graph, visitiedGraph);
				} // callDfs

			} // arrayCheck

		} // forDirection

		stepServivalDay = Math.max(servivalDay, stepServivalDay);
		visitiedGraph[positionI][positionJ] = false;
	}// dfs()

}// class
