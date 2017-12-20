package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidasTest4 {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest3.txt"));

		 Scanner sc = new Scanner(System.in);

		int result = 0;
		int N = sc.nextInt();
		ArrayList<Integer> numberList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			numberList.add(sc.nextInt());
		}
		numberList.sort(null);

		int[] gapList = new int[N - 1];
		int minGap = Integer.MAX_VALUE;

		for (int i = 0; i < N - 1; i++) {
			gapList[i] = numberList.get(i + 1) - numberList.get(i);
		}

		for (int i = 0; i < gapList.length - 1; i++) {
			minGap = Math.min(minGap, getGCD(gapList[i], gapList[i + 1]));
		}
		boolean[] graph = new boolean[numberList.get(numberList.size() - 1) + 1];

		for (int i = 0; i < N; i++) {
			graph[numberList.get(i)] = true;
		}

		for (int i = numberList.get(0); i < graph.length; i += minGap) {
			if (!graph[i]) {
				result++;
			}

		}

		System.out.println(result);

	}// main

	public static int getGCD(int val1, int val2) {
		int r = 1;

		while (r > 0) {
			r = val1 % val2;
			val1 = val2;
			val2 = r;
		}

		return val1;
	}

}// class
