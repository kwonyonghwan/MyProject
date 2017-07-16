package dfs;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Laboratory2 {
	static int maxSafetyArea;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("src/dfs/Laboratory.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt();
			int numberOfM = sc.nextInt();
			int[][] graph = new int[numberOfN][numberOfM];
			maxSafetyArea = 0;

			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfM; j++) {
					graph[i][j] = sc.nextInt();
				}
			} // forSetting

			for (int i = 0; i < (numberOfN * numberOfM) - 2; i++) {
				for (int j = i + 1; j < (numberOfN * numberOfM) - 1; j++) {
					for (int k = j + 1; k < numberOfN * numberOfM; k++) {

						if (graph[i / (numberOfM)][i % (numberOfM)] > 0 || graph[j / (numberOfM)][j % (numberOfM)] > 0
								|| graph[k / (numberOfM)][k % (numberOfM)] > 0) {
							continue;
						}
						
						graph[i / (numberOfM)][i % (numberOfM)] = 1;
						graph[j / (numberOfM)][j % (numberOfM)] = 1;
						graph[k / (numberOfM)][k % (numberOfM)] = 1;

						dfsCountSafetyArea(graph);

						graph[i / (numberOfM)][i % (numberOfM)] = 0;
						graph[j / (numberOfM)][j % (numberOfM)] = 0;
						graph[k / (numberOfM)][k % (numberOfM)] = 0;
					}
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + maxSafetyArea);
		} // forTest

	}// main

	public static void dfsSpreadVirus(int positionI, int positionJ, int[][] graph) {

		graph[positionI][positionJ] = 2;

		// 상
		if (positionI - 1 > -1 && graph[positionI - 1][positionJ] == 0) {
			dfsSpreadVirus(positionI - 1, positionJ, graph);
		}
		// 우
		if (positionJ + 1 < graph[0].length && graph[positionI][positionJ + 1] == 0) {
			dfsSpreadVirus(positionI, positionJ + 1, graph);
		}
		// 하
		if (positionI + 1 < graph.length && graph[positionI + 1][positionJ] == 0) {
			dfsSpreadVirus(positionI + 1, positionJ, graph);
		}
		// 좌
		if (positionJ - 1 > -1 && graph[positionI][positionJ - 1] == 0) {
			dfsSpreadVirus(positionI, positionJ - 1, graph);
		}

	}// dfsSpreadVirus()

	public static void dfsCountSafetyArea(int[][] graph) {

		int[][] tempBoard = new int[graph.length][graph[0].length];
		for (int i = 0; i < graph.length; i++) {
			tempBoard[i] = Arrays.copyOf(graph[i], graph[i].length);
		}//copyArray

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (tempBoard[i][j] == 2) {
					dfsSpreadVirus(i, j, tempBoard);
				}
			}
		}//dfs()

		int count = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (tempBoard[i][j] == 0) {
					count++;
				}
			}
		}
		maxSafetyArea = Math.max(maxSafetyArea, count);

	}// dfsCountSafetyArea()

}// class
