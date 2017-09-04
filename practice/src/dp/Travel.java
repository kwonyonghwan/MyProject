package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithm.PrintGraph;

public class Travel {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Travel.txt"));

		// Scanner sc = new Scanner(System.in);

		int sizeOfBag = sc.nextInt() + 1;
		int countOfItem = sc.nextInt() + 1;

		int[][] itemList = new int[countOfItem][2];
		int[][] bottomUpMap = new int[countOfItem][sizeOfBag];

		for (int i = 1; i < countOfItem; i++) {
			itemList[i][0] = sc.nextInt();
			itemList[i][1] = sc.nextInt();
		}

		for (int i = 1; i < countOfItem; i++) {
			for (int j = 1; j < sizeOfBag; j++) {
				if ((j - itemList[i][0]) >= 0) {
					bottomUpMap[i][j] = Math.max(bottomUpMap[i - 1][j], bottomUpMap[i - 1][j - itemList[i][0]] + itemList[i][1]);
				} else {
					bottomUpMap[i][j] = bottomUpMap[i - 1][j];
				}

			}
		}

		PrintGraph print = new PrintGraph();
		print.printGraph(bottomUpMap);

	}// main

}// class
