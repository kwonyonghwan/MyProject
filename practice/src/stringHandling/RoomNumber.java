package stringHandling;

import java.util.Scanner;

public class RoomNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String inputString = "9999";
		char[] inputCharArray = inputString.toCharArray();
		int[] numberCountList = new int[9];
		int countOfRoomNumberSet = 0;

		for (int i = 0; i < inputCharArray.length; i++) {
			if (Character.getNumericValue(inputCharArray[i]) == 9) {
				numberCountList[6]++;
			} else {
				numberCountList[Character.getNumericValue(inputCharArray[i])]++;
			}
		}

		numberCountList[6] = (numberCountList[6] / 2) + (numberCountList[6] % 2);

		for (int i = 0; i < 9; i++) {
			countOfRoomNumberSet = Math.max(countOfRoomNumberSet, numberCountList[i]);
		}

		System.out.println(countOfRoomNumberSet);
	}// main

}// class
