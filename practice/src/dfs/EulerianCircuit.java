package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EulerianCircuit {
	static boolean[] visitiedMap;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/EulerianCircuit.txt"));

		int sizeOfGraph = sc.nextInt() + 1;
		int[][] graph = new int[sizeOfGraph][sizeOfGraph];

		for (int i = 1; i < sizeOfGraph; i++) {
			for (int j = 1; j < sizeOfGraph; j++) {
				graph[i][j] = sc.nextInt();
			}
		} // forSetting
		visitiedMap = new boolean[sizeOfGraph];

		for (int i = 1; i < sizeOfGraph; i++) {
			if (!visitiedMap[i]) {
				visitiedMap[i] = true;
				boolean[][] visitiedMap = new boolean[sizeOfGraph][sizeOfGraph];
				DFS(i, i, new ArrayList<Integer>(), graph,visitiedMap);
			}
		}

	}// main

	public static void DFS(int firstVertex,int startVertex, ArrayList<Integer> resultList, int[][] graph, boolean[][] visitiedMap2) {

		resultList.add(startVertex);

		for (int nextVertex = 1; nextVertex < graph.length; nextVertex++) {
			if (!visitiedMap2[startVertex][nextVertex]&&graph[startVertex][nextVertex] > 0) {
				visitiedMap2[startVertex][nextVertex] = true;
				visitiedMap[nextVertex] = true;
				DFS(firstVertex, nextVertex, resultList, graph,visitiedMap2);
			}
		}
		
		if(firstVertex == startVertex){
			for (int vertex : resultList) {
				System.out.print(vertex+" ");
			}
		}

	}// DfsFindMAX()

}// class
