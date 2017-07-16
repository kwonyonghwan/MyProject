package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EasyStairCount {

	public static void main(String[] args) throws FileNotFoundException {

		// Scanner sc = new Scanner(new
		// FileInputStream("src/dp/ContinuitySum.txt"));

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		
		int inputNumber = 31;
		int[][] bottomUpMap = new int[inputNumber+1][12];

		for(int i=2; i<11; i++){
				bottomUpMap[1][i] = 1;
		}
		
		for(int i=2; i<inputNumber+1; i++){
			for(int j=1; j<11; j++){
				bottomUpMap[i][j] = (bottomUpMap[i-1][j-1]+bottomUpMap[i-1][j+1])%1000000000;
			}
		}
		
		int result = 0;
	for(int i=1; i<11; i++){
			result = (result+ bottomUpMap[inputNumber][i])%1000000000;
	}
		
		
		System.out.println((result % 1000000000));

	}// main

}// class
