package test;

import java.io.FileNotFoundException;

public class BaeminTest7 {

	public static void main(String[] args) throws FileNotFoundException {

		int N = 1;
		String S = "";

		S = S.replaceAll("J", "I");
		S = S.replaceAll("K", "J");
		int result = 0;
		String[] reservedSeats = S.split(" ");

		boolean[][] seat = new boolean[N][10];
		
		if(S.length()>0){
			for (int i = 0; i < reservedSeats.length; i++) {
				seat[Character.getNumericValue(reservedSeats[i].charAt(0)) - 1][(int) reservedSeats[i].charAt(1)- 'A'] = true;
			}
		}

		for (int i = 0; i < N; i++) {

			for (int j = 0; j < 3; j++) {
				if (seat[i][j]) {
					break;
				}
				if (j == 2) {
					result++;
				}
			}

			for (int j = 3; j < 6; j++) {
				if (seat[i][j]) {
					break;
				}
				if (j == 5) {
					result++;
					for (int k = 3; k < 6; k++) {
						seat[i][k] = true;
					}
				}
			}

			for (int j = 4; j < 7; j++) {
				if (seat[i][j]) {
					break;
				}
				if (j == 6) {
					result++;
				}
			}

			for (int j = 7; j < 10; j++) {
				if (seat[i][j]) {
					break;
				}
				if (j == 9) {
					result++;
				}
			}

		}

		System.out.println(result);
//		return result;
		
	}// main

}// class
