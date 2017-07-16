package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SelectNumber {

	static ArrayList<Integer> EqualNumberList;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/SelectNumber.txt"));

		int lengthOfArray = sc.nextInt() + 1;
		int[] numberList = new int[lengthOfArray];
		EqualNumberList = new ArrayList<Integer>();
		for (int i = 1; i < lengthOfArray; i++) {
			int temp = sc.nextInt();
			if (temp == i) {
				EqualNumberList.add(temp);
				continue;
			}
			numberList[i] = temp;
		}

		for (int i = 1; i < lengthOfArray; i++) {
			if (numberList[i] > 0) {
				boolean[][] visitiedMap = new boolean[lengthOfArray][2];
				ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
				DFS(numberList, visitiedMap, tempArrayList, i);
			}
		}  
		EqualNumberList.sort(null);
		System.out.println(EqualNumberList.size());
		for (int i = 0; i < EqualNumberList.size(); i++) {
			System.out.println(EqualNumberList.get(i));
		}
	}// main

	public static void DFS(int[] numberList, boolean[][] visitiedMap, ArrayList<Integer> tempArrayList,
			int startPosition) {

		visitiedMap[startPosition][0] = true;
		tempArrayList.add(startPosition);

		if (!visitiedMap[numberList[startPosition]][1] && numberList[numberList[startPosition]] > 0) {
			visitiedMap[numberList[startPosition]][1] = true;
			DFS(numberList, visitiedMap, tempArrayList, numberList[startPosition]);
		}

		boolean flag = false;
		for (int i = 0; i < tempArrayList.size(); i++) {
			if (visitiedMap[tempArrayList.get(i)][0] != visitiedMap[tempArrayList.get(i)][1]) {
				flag = true;
			}
		}

		if (!flag) {
			for (int i = 0; i < tempArrayList.size(); i++) {
				if (numberList[tempArrayList.get(i)] > 0) {
					EqualNumberList.add(tempArrayList.get(i));
					numberList[tempArrayList.get(i)] = 0;
				}  
			}
		}

		visitiedMap[startPosition][0] = false;
	}// DfsFindMAX()

}// class
