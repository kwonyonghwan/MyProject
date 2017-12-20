package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.Position.Bias;

import algorithm.PrintGraph;

public class IceBerg {
	static int[][] directionList = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/IceBerg.txt"));

		// Scanner sc = new Scanner(System.in);

		int numberOfI = sc.nextInt();
		int numberOfJ = sc.nextInt();
		int[][] graph = new int[numberOfI][numberOfJ];
		int[][] countMap = new int[numberOfI][numberOfJ];
		boolean splitIsland = false;
		int year = 0;

		for (int i = 0; i < numberOfI; i++) {
			for (int j = 0; j < numberOfJ; j++) {
				graph[i][j] = sc.nextInt();
			}
		} // forSetting

		while (!splitIsland) {
			year++;

			boolean noIsland = true;
			for (int i = 0; i < numberOfI; i++) {
				for (int j = 0; j < numberOfJ; j++) {
					int seaCount = 0;
					for (int k = 0; k < 4; k++) {
						if(graph[i][j]>0){
							noIsland = false;
							
							if (i + directionList[k][0] > -1 && i + directionList[k][0] < graph.length
									&& j + directionList[k][1] > -1 && j + directionList[k][1] < graph[0].length
									&& graph[i + directionList[k][0]][j + directionList[k][1]] == 0) {
								seaCount++;
							}
						}
					}
					countMap[i][j] = seaCount;
				}
			} // forCountSea
			
			if(noIsland){
				break;
			}

			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					if (graph[i][j] - countMap[i][j] < 0) {
						graph[i][j] = 0;
						continue;
					}
					graph[i][j] = graph[i][j] - countMap[i][j];
				}
			} // makeNextMap

			int countOfIsland = 0;

			boolean[][] visitedMap = new boolean[numberOfI][numberOfJ];
			for (int i = 0; i < graph.length; i++) {
				for (int j = 0; j < graph[0].length; j++) {
					if (graph[i][j] > 0 && !visitedMap[i][j]) {
						countOfIsland++;
						visitedMap[i][j] = true;
						DFS(i, j, graph, visitedMap);
					}
				}
			} // forDFSAll

			if (countOfIsland > 1) {
				splitIsland = true;
			}
		} // whileSplit
		
		if (splitIsland) {
			System.out.println(year);
		} else {
			System.out.println(0);
		}

	}// main

	private static void DFS(int positionI, int positionJ, int[][] graph, boolean[][] visitedMap) {

		for (int k = 0; k < 4; k++) {
			if (positionI + directionList[k][0] > -1 && positionI + directionList[k][0] < graph.length
					&& positionJ + directionList[k][1] > -1 && positionJ + directionList[k][1] < graph[0].length
					&& graph[positionI + directionList[k][0]][positionJ + directionList[k][1]] > 0
					&& !visitedMap[positionI + directionList[k][0]][positionJ + directionList[k][1]]) {
				visitedMap[positionI + directionList[k][0]][positionJ + directionList[k][1]] = true;
				DFS(positionI + directionList[k][0], positionJ + directionList[k][1], graph, visitedMap);
			}
		} // forDirectionList

	}// DFS()

}// class
