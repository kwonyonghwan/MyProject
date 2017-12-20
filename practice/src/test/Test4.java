package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test4 {
	static int size;
	static int[][] directionList = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/Test4.txt"));

		// Scanner sc = new Scanner(System.in);
		int numberOfVertex = sc.nextInt() + 2;

		int[][] graph = new int[numberOfVertex][numberOfVertex];
		boolean[][] visitiedMap = new boolean[numberOfVertex][numberOfVertex];

		int countOfConnectedComponent = 0;

		for (int i = 1; i < numberOfVertex - 1; i++) {
			for (int j = 1; j < numberOfVertex - 1; j++) {
				graph[i][j] = sc.nextInt();
			}
		} // forSetting

		ArrayList<Integer> resultList = new ArrayList<Integer>();
		for (int i = 1; i < numberOfVertex - 1; i++) {
			for (int j = 1; j < numberOfVertex - 1; j++) {
				if (!visitiedMap[i][j] && graph[i][j]==1) {
					countOfConnectedComponent++;
					size = 1;
					dfs(graph, visitiedMap, i, j);
					resultList.add(size);
				}
			}
		} // forSetting
		
		
		System.out.println(countOfConnectedComponent);
		resultList.sort(null);
		for(int i=0; i<resultList.size(); i++){
			System.out.print(resultList.get(i)+" ");
		}
		
	}// main

	private static void dfs(int[][] graph, boolean[][] visitied, int positionI, int positionJ) {

		visitied[positionI][positionJ] = true;

		for (int i = 0; i < 3; i++) {
			int nextPositionI = positionI + directionList[i][0];
			int nextPositionJ = positionJ + directionList[i][1];

			if (graph[nextPositionI][nextPositionJ] == 1 && !visitied[nextPositionI][nextPositionJ]) {

				dfs(graph, visitied, nextPositionI, nextPositionJ);
				size++;
			}

		} // for

		
		
	}
}// class
