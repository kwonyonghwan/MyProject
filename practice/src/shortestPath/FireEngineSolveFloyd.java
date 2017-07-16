package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FireEngineSolveFloyd {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/FireEngine.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfVillage = sc.nextInt() + 1;
			int numberOfRoad = sc.nextInt();

			int[] FireVillageList = new int[sc.nextInt()];
			int[] FireStationLsit = new int[sc.nextInt()];

			int[][] graph = new int[numberOfVillage][numberOfVillage];

			for (int i = 0; i < numberOfVillage; i++) {
				for (int j = 0; j < numberOfVillage; j++) {
					graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}

			for (int i = 0; i < numberOfRoad; i++) {
				int aVillage = sc.nextInt();
				int bVillage = sc.nextInt();
				graph[aVillage][bVillage] = graph[bVillage][aVillage] = sc.nextInt();
			}

			for (int i = 0; i < FireVillageList.length; i++) {
				FireVillageList[i] = sc.nextInt();
			}

			for (int i = 0; i < FireStationLsit.length; i++) {
				FireStationLsit[i] = sc.nextInt();
			}

			for (int k = 0; k < numberOfVillage; k++) {
				for (int i = 0; i < numberOfVillage; i++) {
					for (int j = 0; j < numberOfVillage; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}//folyd

			int result = 0;

			for (int i = 0; i < FireVillageList.length; i++) {
				int min = Integer.MAX_VALUE / 2;
				for (int j = 0; j < FireStationLsit.length; j++) {
					if (graph[FireVillageList[i]][FireStationLsit[j]] < min) {
						min = graph[FireVillageList[i]][FireStationLsit[j]];
					}
				} // forJ

				result += min;

			} // forI

			System.out.println(result);

		} // forTest
	}// main

}// class
