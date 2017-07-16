package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GreedPanda2 {
	static int resultServivalDay;
	static int stepServivalDay;
	static int[][] directionList = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };
	static int[][] memoization;
	static int count = 0;;

	public static void main(String[] args) throws IOException {

		// Scanner sc = new Scanner(new
		// FileInputStream("src/dp/GreedPanda.txt"));

		// Scanner sc = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/dp/GreedPanda.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int graphLength = Integer.parseInt(st.nextToken());
		int[][] graph = new int[graphLength][graphLength];
		memoization = new int[graphLength][graphLength];

		for (int i = 0; i < graphLength; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < graphLength; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < graphLength; i++) {
			for (int j = 0; j < graphLength; j++) {
				resultServivalDay = Math.max(resultServivalDay, dfs(i, j, graph));
			}
		}

		// 이 부분에서 정답을 출력하십시오.
		System.out.println(resultServivalDay);

	}// main

	private static int dfs(int positionI, int positionJ, int[][] graph) {

		if (memoization[positionI][positionJ] > 0) {
			return memoization[positionI][positionJ];
		} // checkMemoization

		memoization[positionI][positionJ] = 1;

		for (int i = 0; i < 4; i++) {
			int nextPositionI = positionI + directionList[i][0];
			int nextPositionJ = positionJ + directionList[i][1];
			if (nextPositionI > -1 && nextPositionI < graph.length && nextPositionJ > -1
					&& nextPositionJ < graph[0].length
					&& graph[nextPositionI][nextPositionJ] > graph[positionI][positionJ]) {

				memoization[positionI][positionJ] = Math.max(memoization[positionI][positionJ],dfs(nextPositionI, nextPositionJ, graph)+1);
			} // if

		} // forDirection

		// stepServivalDay = Math.max(servivalDay, stepServivalDay);
		return memoization[positionI][positionJ];
	}// dfs()

}// class
