package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class resultPosition implements Comparable<resultPosition> {

	int i;
	int j;

	public resultPosition(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public int compareTo(resultPosition o) {
		if (this.i * this.j > o.i * o.j) {
			return 1;
		} else if (this.i * this.j < o.i * o.j) {
			return -1;
		}else{
			if(this.j> o.j){
				return 1;
			}else{
				return -1;
			}
		}
	}

}

public class No1258 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No1258.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;
		int T = sc.nextInt();

		for (test_Case = 1; test_Case <= T; test_Case++) {
			long result = 0;
			int countOfResult = 0;
			int sizeOfGraph = sc.nextInt() + 2;

			int[][] graph = new int[sizeOfGraph][sizeOfGraph];
			boolean[][] visitiedMap = new boolean[sizeOfGraph][sizeOfGraph];
			ArrayList<resultPosition> resultList = new ArrayList<resultPosition>();

			for (int i = 1; i < sizeOfGraph - 1; i++) {
				for (int j = 1; j < sizeOfGraph - 1; j++) {
					graph[i][j] = sc.nextInt();
				}
			} // forSetting

			for (int i = 1; i < sizeOfGraph - 1; i++) {
				for (int j = 1; j < sizeOfGraph - 1; j++) {
					if (!visitiedMap[i][j] && graph[i][j] > 0) {
						resultPosition resultValue = dfs(i, j, graph, 1, 1);
						resultList.add(resultValue);

						for (int k = 0; k < resultValue.j; k++) {
							for (int l = 0; l < resultValue.i; l++) {
								visitiedMap[i + k][j + l] = true;
							}
						}

					}

				}
			} // forSetting
			resultList.sort(null);

			System.out.print("#" + test_Case + " " + resultList.size());

			for (int i = 0; i < resultList.size(); i++) {
				System.out.print(" " + resultList.get(i).j + " " + resultList.get(i).i);
			}
			System.out.println();

		} // forTestCase

	}// main

	private static resultPosition dfs(int positionI, int positionJ, int[][] graph, int lengthOfRow, int lengthOfCol) {

		if (graph[positionI][positionJ + 1] > 0) {
			lengthOfRow++;
			return dfs(positionI, positionJ + 1, graph, lengthOfRow, lengthOfCol);
		}

		if (graph[positionI + 1][positionJ] > 0) {
			lengthOfCol++;
			return dfs(positionI + 1, positionJ, graph, lengthOfRow, lengthOfCol);
		}

		resultPosition temp = new resultPosition(lengthOfRow, lengthOfCol);
		return temp;
	}

}// class