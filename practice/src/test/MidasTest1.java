package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidasTest1 {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest1.txt"));

		 Scanner sc = new Scanner(System.in);

		int n = sc.nextInt()+1;
		int m = sc.nextInt()+1;
		int k = sc.nextInt();
		boolean[][] graph = new boolean[n][m];

		int[] trainList = new int[k * 3];

		for (int i = 0; i < k; i++) {
			trainList[i * 3] = sc.nextInt();
			trainList[i * 3 + 1] = sc.nextInt();
			trainList[i * 3 + 2] = sc.nextInt();
		}

		int CountOfTrain = 0;

		for (int i = 0; i < k; i++) {
			int tempIndex = trainList[i*3+1];
			for (; tempIndex <= trainList[i*3+2]; tempIndex++) {
				graph[trainList[i * 3]][tempIndex] = true;
			}
		}
		
		for(int i=1; i<n; i++){
			for(int j=1; j<m; j++){
				if(!graph[i][j]){
					CountOfTrain++;
				}
			}
		}

		System.out.println(CountOfTrain);

	}// main

}// class
