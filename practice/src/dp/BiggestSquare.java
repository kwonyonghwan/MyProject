package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithm.PrintGraph;

public class BiggestSquare {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/BiggestSquare.txt"));
		// Scanner sc = new Scanner(System.in);

		int sizeOfN = sc.nextInt() + 2;
		int sizeOfM = sc.nextInt() + 2;
		sc.nextLine();
		int[][] graph = new int[sizeOfN][sizeOfM];

		for (int i = 1; i < sizeOfN - 1; i++) {
			String temp = sc.nextLine();
			for (int j = 1; j < sizeOfM - 1; j++) {
				if (Character.getNumericValue(temp.charAt(j - 1)) == 0) {
					continue;
				} else {
					graph[i][j] = graph[i][j - 1] + 1;
				}
			}
		}

		PrintGraph print = new PrintGraph();
		print.printGraph(graph);

		int maxValue = 0;

		for (int i = 1; i < sizeOfN - 1; i++) {
			for (int j = 1; j < sizeOfM - 1; j++) {

				if (graph[i][j] > 0) {
					int step = 0;
					int sizeOfSquare = graph[i][j];
					for (int k = 1; k < graph[i][j]; k++) {
						++step;
						if (graph[i - k][j] == 0) {
							sizeOfSquare = Math.min(sizeOfSquare, step);
							break;
						}

						sizeOfSquare = Math.min(sizeOfSquare, graph[i - k][j]);
						if (graph[i - k][j] > sizeOfSquare) {
							break;
						}

					}
					maxValue = Math.max(maxValue, sizeOfSquare);

				}
			}
		}

		System.out.println(maxValue * maxValue);

	}// main

}// class
