package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ColorWeakness {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/ColorWeakness.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfMap = sc.nextInt();

			boolean[][] visitedMap = new boolean[sizeOfMap][sizeOfMap];
			char[][] colorNomalMap = new char[sizeOfMap][sizeOfMap];
			char[][] colorWeakness = new char[sizeOfMap][sizeOfMap];

			for (int i = 0; i < sizeOfMap; i++) {
				String temp = sc.next();
				colorNomalMap[i] = temp.toCharArray();
			}

			for (int i = 0; i < sizeOfMap; i++) {
				for (int j = 0; j < sizeOfMap; j++) {
					if (colorNomalMap[i][j] == 'G') {
						colorWeakness[i][j] = 'R';
					} else {
						colorWeakness[i][j] = colorNomalMap[i][j];
						
					}
				}
			} // forCopy

			int nomalCount = 0;
			int colorWeaknessCount = 0;

			for (int i = 0; i < sizeOfMap; i++) {
				for (int j = 0; j < sizeOfMap; j++) {
					if (!visitedMap[i][j]) {
						nomalCount++;
						searchSectionDFS(i, j, colorNomalMap, visitedMap);
					}
				}
			} // fordfs

			for (int i = 0; i < sizeOfMap; i++) {
				for (int j = 0; j < sizeOfMap; j++) {
					visitedMap[i][j] = false;
				}
			} // fordfs

			for (int i = 0; i < sizeOfMap; i++) {
				for (int j = 0; j < sizeOfMap; j++) {
					if (!visitedMap[i][j]) {
						colorWeaknessCount++;
						searchSectionDFS(i, j, colorWeakness, visitedMap);
					}
				}
			} // fordfs

			System.out.println(nomalCount + " " + colorWeaknessCount);

		} // forTest

	}// main

	public static void searchSectionDFS(int i, int j, char[][] colorMap, boolean[][] visitedMap) {

		visitedMap[i][j] = true;

		// ╩С
		if (i -1> -1 && !visitedMap[i - 1][j] && colorMap[i][j] == colorMap[i - 1][j]) {
			searchSectionDFS(i - 1, j, colorMap, visitedMap);
		}

		// го
		if (i+1 < colorMap.length  && !visitedMap[i + 1][j] && colorMap[i][j] == colorMap[i + 1][j]) {
			searchSectionDFS(i + 1, j, colorMap, visitedMap);
		}

		// аб
		if (j -1> -1 && !visitedMap[i][j - 1] && colorMap[i][j] == colorMap[i][j - 1]) {
			searchSectionDFS(i, j - 1, colorMap, visitedMap);
		}

		// ©Л//
		if (j+1 < colorMap.length && !visitedMap[i][j + 1] && colorMap[i][j] == colorMap[i][j + 1]) {
			searchSectionDFS(i, j + 1, colorMap, visitedMap);
		}

	}

}// class
