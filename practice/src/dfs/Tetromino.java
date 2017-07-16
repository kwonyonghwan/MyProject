package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tetromino {

	static int MAXResult;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/Tetromino.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			MAXResult = 0;
			int numberOfN = sc.nextInt();
			int numberOfM = sc.nextInt();

			int[][] tetrominoMap = new int[numberOfN][numberOfM];
			boolean[][] visitedMap = new boolean[numberOfN][numberOfM];

			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfM; j++) {
					tetrominoMap[i][j] = sc.nextInt();
				}
			} // forSetting

			for (int i = 0; i < numberOfN; i++) {
				for (int j = 0; j < numberOfM; j++) {
					DfsFindMAX(i, j, 0, 1, tetrominoMap, visitedMap);
				}
			} // forSetting

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case + " " + MAXResult);

		} // forTest

	}// main

	public static void DfsFindMAX(int i, int j, int sum, int count, int[][] tetrominoMap, boolean[][] visitedMap) {

		// COUNTüũ
		if (count > 4) {
			return;
		}
		visitedMap[i][j] = true;

		// SUM
		sum += tetrominoMap[i][j];
		MAXResult = Math.max(MAXResult, sum);
		
		// ���� 2�ϴ�
		if (count == 2) {
			ArrayList<Integer> checkFuckArray = new ArrayList<Integer>();
			// ��
			if (i - 1 > 0 && !visitedMap[i - 1][j]) {
				checkFuckArray.add(tetrominoMap[i - 1][j]);
			}
			// ��
			if (i + 1 < tetrominoMap.length && !visitedMap[i + 1][j]) {
				checkFuckArray.add(tetrominoMap[i + 1][j]);
			}
			// ��
			if (j - 1 > 0 && !visitedMap[i][j - 1]) {
				checkFuckArray.add(tetrominoMap[i][j - 1]);
			}
			// ��
			if (j + 1 < tetrominoMap[0].length && !visitedMap[i][j + 1]) {
				checkFuckArray.add(tetrominoMap[i][j + 1]);
			}

			for (int k = 0; k < checkFuckArray.size(); k++) {
				MAXResult = Math.max(MAXResult,
						sum + checkFuckArray.get(k) + checkFuckArray.get(((k + 1) % (checkFuckArray.size()))));
			}

		} // checkFuckYouShape

		// ȣ��
		// ��
		if (i - 1 > 0 && !visitedMap[i - 1][j]) {
			DfsFindMAX(i - 1, j, sum, count + 1, tetrominoMap, visitedMap);
		}

		// ��
		if (i + 1 < tetrominoMap.length && !visitedMap[i + 1][j]) {
			DfsFindMAX(i + 1, j, sum, count + 1, tetrominoMap, visitedMap);
		}
		// ��
		if (j - 1 > 0 && !visitedMap[i][j - 1]) {
			DfsFindMAX(i, j - 1, sum, count + 1, tetrominoMap, visitedMap);
		}
		// ��
		if (j + 1 < tetrominoMap[0].length && !visitedMap[i][j + 1]) {
			DfsFindMAX(i, j + 1, sum, count + 1, tetrominoMap, visitedMap);
		}

		visitedMap[i][j] = false;

	}//DfsFindMAX()

}// class
