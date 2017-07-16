package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Party {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/Party.txt"));

		// Scanner sc = new Scanner(System.in);

		int maxValue = 0;
		int countOfVillage = sc.nextInt() + 1;
		int countOfLoad = sc.nextInt();
		int partyVillage = sc.nextInt();

		int[][] graph = new int[countOfVillage][countOfVillage];

		for (int i = 0; i < countOfVillage; i++) {
			for (int j = 0; j < countOfVillage; j++) {
				if (i == j) {
					graph[i][j] = 0;
				} else {
					graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}
		}

		for (int i = 0; i < countOfLoad; i++) {
			graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		} // forSetting

		for (int k = 0; k < countOfVillage; k++) {
			for (int i = 0; i < countOfVillage; i++) {
				for (int j = 0; j < countOfVillage; j++) {
					graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
				}
			}
		}

		for (int i = 1; i < countOfVillage; i++) {
			maxValue = Math.max(maxValue, graph[partyVillage][i] + graph[i][partyVillage]);
		}

		System.out.println(maxValue);

	}// main

}// class
