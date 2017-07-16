package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputArray {

	public static void main(String[] args) throws FileNotFoundException {

		String inputString = "1213002";

		Solution(inputString);
	}// main

	public static void Solution(String N) {
		// int[] answer = {};
		int answer = 0;
		int[] countNumber = new int[10];
		boolean oddFlag = false;
		boolean zeroFlag = false;
		
		for (int i = 0; i < N.length(); i++) {
			countNumber[Character.getNumericValue(N.charAt(i))]++;
		}

		for (int i = 1; i < 10; i++) {
			if ((countNumber[i]) >1) {
				if(!zeroFlag){
					zeroFlag = true;
				}
				answer += (countNumber[i]/2)*2;
			}
		}
		
		if(zeroFlag){
			answer += (countNumber[0]/2)*2;
		}
	
		for (int i = 0; i < 10; i++) {
			if (!oddFlag && (countNumber[i]) % 2 == 1) {
				oddFlag = true;
			}
		}

		if (oddFlag) {
			answer++;
		}
		System.out.println(answer);

	}
}// class
