package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CombinationOperation {

	static int maxNumber = Integer.MIN_VALUE;
	static int minNumber = Integer.MAX_VALUE;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/CombinationOperation.txt"));

		// Scanner sc = new Scanner(System.in);

		int sizeOfArray = sc.nextInt();
		int[] numberArray = new int[sizeOfArray];
		int[] countOfOperation = new int[4];
		boolean[] visitiedMap = new boolean[sizeOfArray];
		String temp = "";
		
		for (int i = 0; i < sizeOfArray; i++) {
			numberArray[i] = sc.nextInt();
		}

		for (int i = 0; i < 4; i++) {
			countOfOperation[i] = sc.nextInt();
		}

		for (int i = 0; i < sizeOfArray; i++) {

			visitiedMap[i] = true;
			temp+= numberArray[i];
			dfs(0, visitiedMap, countOfOperation, numberArray[i], numberArray, temp);
			visitiedMap[i] = false;
		}

		System.out.println(maxNumber+"\n"+minNumber);
		
	}// main

	private static void dfs(int countOfAdd, boolean[] visitiedMap, int[] countOfOperation, int resultNumber, int[] numberArray, String temp) {

		// addOperation
		// visit
		// addNumber && call dfs
		int tempIndexI = -1;
		int tempIndexJ = -1;

		for (int i = 0; i < visitiedMap.length; i++) {

			if (!visitiedMap[i]) {
				visitiedMap[i] = true;
				tempIndexI = i;
				for (int j = 0; j < 4; j++) {

					if(countOfOperation[j]>0){
						countOfOperation[j]--;
						tempIndexJ = j;
						countOfAdd++;
						switch (j) {
						case 0:
							resultNumber += numberArray[i];
							break;
							
						case 1:
							resultNumber -= numberArray[i];
							break;
							
						case 2:
							resultNumber *= numberArray[i];
							break;
							
						default:
							resultNumber /= numberArray[i];
							break;
						}
						temp= temp+j+numberArray[i];
						dfs(countOfAdd, visitiedMap, countOfOperation, resultNumber, numberArray, temp);
						visitiedMap[tempIndexI] = false;
						countOfOperation[tempIndexJ]++;
						countOfAdd--;
					}

				}//forOperation
				
			}//if

		}

		// i==size Max
		
		if(countOfAdd== visitiedMap.length-1){
			System.out.println(temp);
			minNumber = Math.min(minNumber, resultNumber);
			maxNumber = Math.max(maxNumber, resultNumber);
		}
		// visit

	}// dfs()

}// class
