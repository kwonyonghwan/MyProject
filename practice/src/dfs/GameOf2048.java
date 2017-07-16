package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class GameOf2048 {

	static int boradSize;
	static int result = 0;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/GameOf2048_input.txt"));
		boradSize = sc.nextInt();

		int[][] board = new int[boradSize][boradSize];

		for (int i = 0; i < boradSize; i++) {
			for (int j = 0; j < boradSize; j++) {
				int temp = sc.nextInt();
				board[i][j] = temp;
				if (temp > result) {
					result = temp;
				}
			}
		}

		// 호출
		for (int i = 0; i < 4; i++) {
			int depth = 1;
			Dfs(board, i, depth);
		}

		System.out.println(result);
	}// main

	public static void Dfs(int[][] board, int direction, int depth) {
		// direction0하 1좌 2상 3우
		depth++;
		int[][] tempBoard = new int[boradSize][boradSize];
		for (int i = 0; i < board.length; i++) {
			tempBoard[i] = Arrays.copyOf(board[i], board[i].length);
		}
		
		if (depth > 5) {
			return;
		}

		switch (direction) {
		case 0:// 하
			for (int j = 0; j < boradSize; j++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int index = boradSize - 1;
				for (int i = boradSize - 1; i > -1; i--) {
					if (tempBoard[i][j] == 0) {
						continue;
					}
					queue.offer(tempBoard[i][j]);
					tempBoard[i][j] = 0;
				} // forI Queue에 넣기

				int queueSize = queue.size();
				for (int i = queueSize - 1; i > -1; i--) {
					int tempQueue = queue.poll();
					if (i == queueSize - 1) {
						tempBoard[index][j] = tempQueue;
						index--;
					} else {
						if (tempBoard[index + 1][j] == tempQueue) {
							tempBoard[index + 1][j] += tempQueue;
							if (tempBoard[index + 1][j] > result) {
								result = tempBoard[index + 1][j];
							}
						} else {
							tempBoard[index][j] = tempQueue;
							index--;
						}
					} // else
				} // forI
			} // forJ
			break;

		case 1: // 좌
			for (int i = 0; i < boradSize; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int index = 0;
				for (int j = 0; j < boradSize; j++) {
					if (tempBoard[i][j] == 0) {
						continue;
					}
					queue.offer(tempBoard[i][j]);
					tempBoard[i][j] = 0;
				} // forJ Queue에 넣기
				int queueSize = queue.size();
				for (int j = 0; j < queueSize; j++) {

					int tempQueue = queue.poll();
					if (j == 0) {
						tempBoard[i][index] = tempQueue;
						index++;
					} else {
						if (tempBoard[i][index - 1] == tempQueue) {
							tempBoard[i][index - 1] += tempQueue;
							if (tempBoard[i][index - 1] > result) {
								result = tempBoard[i][index - 1];
							}
						} else {
							tempBoard[i][index] = tempQueue;
							index++;
						}
					} // else
				} // forJ추가하는 for
			} // forI
			break;

		case 2:// 상
			for (int j = 0; j < boradSize; j++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int index = 0;
				for (int i = 0; i < boradSize; i++) {
					if (tempBoard[i][j] == 0) {
						continue;
					}
					queue.offer(tempBoard[i][j]);
					tempBoard[i][j] = 0;
				} // forI Queue에 넣기
				int queueSize = queue.size();
				for (int i = 0; i < queueSize; i++) {

					int tempQueue = queue.poll();
					if (i == 0) {
						tempBoard[index][j] = tempQueue;
						index++;
					} else {
						if (tempBoard[index - 1][j] == tempQueue) {
							tempBoard[index - 1][j] += tempQueue;
							if (tempBoard[index - 1][j] > result) {
								result = tempBoard[index - 1][j];
							}
						} else {
							tempBoard[index][j] = tempQueue;
							index++;
						}
					} // else
				} // forI
			} // forJ
			break;

		case 3:// 우
			for (int i = 0; i < boradSize; i++) {
				Queue<Integer> queue = new LinkedList<Integer>();
				int index = boradSize - 1;
				for (int j = boradSize - 1; j > -1; j--) {
					if (tempBoard[i][j] == 0) {
						continue;
					}
					queue.offer(tempBoard[i][j]);
					tempBoard[i][j] = 0;
				} // forJ Queue에 넣기

				int queueSize = queue.size();
				for (int j = queue.size() - 1; j > -1; j--) {
					int tempQueue = queue.poll();
					if (j == queueSize - 1) {
						tempBoard[i][index] = tempQueue;
						index--;
					} else {
						if (tempBoard[i][index + 1] == tempQueue) {
							tempBoard[i][index + 1] += tempQueue;
							if (tempBoard[i][index + 1] > result) {
								result = tempBoard[i][index + 1];
							}
						} else {
							tempBoard[i][index] = tempQueue;
							index--;
						}
					} // else
				} // forJ추가하는 for
			} // forI
			break;
		}

		for (int i = 0; i < 4; i++) {
			int temp = i;
			Dfs(tempBoard, temp, depth);
		}
	}// Dfs

}// class
