package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputArray5 {

	public static void main(String[] args) throws FileNotFoundException {

		String inputString = "1213002";

		int[][] board = { { 11, 13, 15, 16 }, { 12, 1, 4, 3 }, { 10, 2, 7, 8 }, { 5, 14, 6, 9 } };

		int[] nums = { 14, 3, 2, 4, 13, 1, 16, 11, 5, 15 };

		Solution(board, nums);

	}// main

	private static void Solution(int[][] board, int[] nums) {
		int answer = 0;

		boolean[] numsArray = new boolean[(board.length * board.length) + 1];

		for (int i = 0; i < nums.length; i++) {
			numsArray[nums[i]] = true;
		}

		boolean[][] Map = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				Map[i][j] = numsArray[board[i][j]];
			}
		} // forSetting

		for (int i = 0; i < Map.length; i++) {
			boolean bingoJ = true;
			boolean bingoK = true;
			int j = 0;
			int k = 0;

			while (j < board.length && k < board.length) {
				if (!Map[i][j]) {
					bingoJ = false;
				}

				if (!Map[k][i]) {
					bingoK = false;
				}
				j++;
				k++;

			} // oneLineSearch
			if (bingoK) {
				answer++;
			}
			if (bingoJ) {
				answer++;
			}
		} // forI

		boolean bingo = true;
		int i = 0;
		int j = 0;
		while (i < board.length) {
			if (!Map[i][j]) {
				bingo = false;
				break;
			}
			i++;
			j++;
		} // oneLineSearch

		if (bingo) {
			answer++;
		}

		bingo = true;
		i = board.length - 1;
		j = 0;
		while (i > -1) {
			if (!Map[i][j]) {
				bingo = false;
				break;
			}
			i--;
			j++;
		} // oneLineSearch

		if (bingo) {
			answer++;
		}

		System.out.println(answer);

	}// Solution

}