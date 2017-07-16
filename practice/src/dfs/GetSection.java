package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class GetSection {
	static int max;
	static Stack<Integer> test;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/GetSection.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int M = sc.nextInt();
			int N = sc.nextInt();
			int numberOfRectangle = sc.nextInt();

			boolean[][] map = new boolean[N][M];

			for (int i = 0; i < numberOfRectangle; i++) {
				int x1, x2, y1, y2;
				x1 = sc.nextInt();
				y1 = sc.nextInt();
				x2 = sc.nextInt();
				y2 = sc.nextInt();

				for (int k = x1; k < x2; k++) {
					for (int j = y1; j < y2; j++) {
						map[k][j] = true;
					}
				}

			} // forInsert
			
			ArrayList<Integer> sectionSizeList = new ArrayList<Integer>();

			int size = 0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (!map[i][j]) {
						max = 0;
						dfs(i, j, map, size);
						sectionSizeList.add(max);
						size = 0;
					}
				}
			}

			System.out.println(sectionSizeList.size());
			Collections.sort(sectionSizeList);

			for (int i = 0; i < sectionSizeList.size(); i++) {
				System.out.print(sectionSizeList.get(i) + " ");
			}

		} // forTest

	}// main

	public static void dfs(int x, int y, boolean[][] map, int size) {
		// ÁÂ¿ì»óÇÏ
		map[x][y] = true;
		max++;

		if (y > 0 && !map[x][y - 1]) {
			dfs(x, y - 1, map, size);
		}
		if (y < map[0].length - 1 && !map[x][y + 1]) {
			dfs(x, y + 1, map, size);
		}
		if (x > 0 && !map[x - 1][y]) {
			dfs(x - 1, y, map, size);
		}
		if (x < map.length - 1 && !map[x + 1][y]) {
			dfs(x + 1, y, map, size);
		}

	}

}// class
