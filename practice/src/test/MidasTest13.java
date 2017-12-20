package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest13 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest11.txt"));

		// Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] pair = new char[M][2];
		for (int i = 0; i < M; i++) {
			pair[i][0] = sc.next().charAt(0);
			pair[i][1] = sc.next().charAt(0);
		}

		char[] sampleArray = new char[N];

		for (int i = 0; i < N; i++) {
			sampleArray[i] = (char) (65 + i);
		}

		boolean endFlag = false;

		while (!endFlag) {
			endFlag = true;
			for (int pairNum = 0; pairNum < M; pairNum++) {

					int index1 = 0;
					int index2 = 0;

					for (int j = 0; j < N; j++) {
						if (sampleArray[j] == pair[pairNum][0]) {
							index1 = j;
						}
						if (sampleArray[j] == pair[pairNum][1]) {
							index2 = j;
						}
					} // forSearch
					

					if (index1 > index2) {
						endFlag = false;
						char tempChar = sampleArray[index2];
						for(int k=index2; k<index1; k++){
							sampleArray[k] = sampleArray[k+1];
						}
						sampleArray[index1] = tempChar;
						
					}
			}//forPair
			if(endFlag){
				break;
			}

		}//while

		System.out.println(sampleArray);
	}// main

}// class
