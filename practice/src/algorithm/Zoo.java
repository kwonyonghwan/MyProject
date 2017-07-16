package algorithm;

import java.util.Scanner;

public class Zoo {

	static int[][] zooMemo;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = 100000;
		int[][] numberOfCase = new int[N + 1][3];

		numberOfCase[1][0] = 1;
		numberOfCase[1][1] = 1;
		numberOfCase[1][2] = 1;

		for (int i = 2; i < N + 1; i++) {
			numberOfCase[i][0] = (numberOfCase[i - 1][0] + numberOfCase[i - 1][1] + numberOfCase[i - 1][2]) % 9901;
			numberOfCase[i][1] = (numberOfCase[i - 1][0] + numberOfCase[i - 1][2]) % 9901;
			numberOfCase[i][2] = (numberOfCase[i - 1][0] + numberOfCase[i - 1][1]) % 9901;
		}
		System.out.println((numberOfCase[N][0] + numberOfCase[N][1] + numberOfCase[N][2]) % 9901);

	}

}// class
