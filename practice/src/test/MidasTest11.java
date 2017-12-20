package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest11 {

	static boolean findResult = false;
	static char[][] pair;
	static int N;
	static int M;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest11.txt"));

		// Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		pair = new char[M][2];
		for (int i = 0; i < M; i++) {
			pair[i][0] = sc.next().charAt(0);
			pair[i][1] = sc.next().charAt(0);
		}

		char[] sampleArray = new char[N];

		for (int i = 0; i < N; i++) {
			sampleArray[i] = (char) (65 + i);
		}

		perm(sampleArray, 0, N, N);
		System.out.println();

	}// main

	public static void perm(char[] arr, int depth, int n, int k) {
		if (depth == k) {
			findResult = check(arr);
			if(findResult){
				System.out.println(arr);
			}
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			if(!findResult){
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
			}
		}

	}

	public static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static boolean check(char[] arr) {

		boolean result = true;

		for (int i = 0; i < M; i++) {
			int index1 = 0;
			int index2 = 0;

			for (int j = 0; j < N; j++) {
				if (arr[j] == pair[i][0]) {
					index1 = j;
				}
				if (arr[j] == pair[i][1]) {
					index2 = j;
				}
			}//forSearch

			if(index1>index2){
				result = false;
				break;
			}
			
		}//forPair

		return result;
	}

}// class
