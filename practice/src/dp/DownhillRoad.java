package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DownhillRoad {

	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/dp/DownhillRoad.txt")));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numberOfI = Integer.parseInt(st.nextToken()) + 2;
		int numberOfJ = Integer.parseInt(st.nextToken()) + 2;
		int[][] graph = new int[numberOfI][numberOfJ];
		int[][] memoizationMap = new int[numberOfI][numberOfJ];
		boolean[][] visitiedMap = new boolean[numberOfI][numberOfJ];

		for (int j = 0; j < numberOfJ; j++) {
			graph[0][j] = graph[numberOfI - 1][j] = -1;
		}

		for (int i = 1; i < numberOfI - 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < numberOfJ; j++) {
				if (j == 0 || j == numberOfJ - 1) {
					graph[i][j] = -1;
					continue;
				}
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		memoizationMap[numberOfI - 2][numberOfJ - 2] = 1;
		DFS(graph, 1, 1, memoizationMap, visitiedMap);

		System.out.println(memoizationMap[1][1]);

	}// main

	private static int DFS(int[][] graph, int positionI, int positionJ, int[][] memoizationMap, boolean[][] visitiedMap) {
		
		for (int i = 0; i < 4; i++) {
			int nextPositionI = positionI + directionList[i][0];
			int nextPositionJ = positionJ + directionList[i][1];

			if (graph[nextPositionI][nextPositionJ] > -1
					&& graph[positionI][positionJ] > graph[nextPositionI][nextPositionJ]) {

				if (memoizationMap[nextPositionI][nextPositionJ] > 0) {
					memoizationMap[positionI][positionJ] += memoizationMap[nextPositionI][nextPositionJ];
					continue;
				}
				
				if (!visitiedMap[nextPositionI][nextPositionJ]) {
					visitiedMap[nextPositionI][nextPositionJ] = true;
					memoizationMap[positionI][positionJ] += DFS(graph, nextPositionI, nextPositionJ, memoizationMap,
							visitiedMap);
				}
			}
		}

		visitiedMap[positionI][positionJ] = false;
		return memoizationMap[positionI][positionJ];
	}// DFS()

}// class
