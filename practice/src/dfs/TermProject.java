package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TermProject {
	static boolean makeTeamFlag = true;
	static boolean endFlag = false;
	static int[] makeTeam;
	static int startPeople;
	static boolean[] MemoizationMap;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/dfs/TermProject.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int resultCount = 0;
			int countOfPeople = sc.nextInt() + 1;
			int[] selectionList = new int[countOfPeople];
			boolean[] visitedMap = new boolean[countOfPeople];
			makeTeam = new int[countOfPeople];
			MemoizationMap = new boolean[countOfPeople];
			makeTeam[0] = -1;

			for (int i = 1; i < countOfPeople; i++) {
				makeTeam[i] = -1;
				selectionList[i] = sc.nextInt();
				if (i == selectionList[i]) {
					makeTeam[i] = 0;
				}
			} // forSetting

			for (int i = 1; i < countOfPeople; i++) {
				if (makeTeam[i] < 0) {
					startPeople = i;
					endFlag = false;
					makeTeam[i] = DFS(selectionList, visitedMap, i);
				}
				if (makeTeam[i] > 0) {
					resultCount++;
				}
			} // DFSAll

			System.out.println(resultCount);
		} // forTestCase

	}// main

	public static int DFS(int[] selectionList, boolean[] visitedMap, int peopleNumber) {

		visitedMap[peopleNumber] = true;
		
		if (!visitedMap[selectionList[peopleNumber]]) {
			if (selectionList[peopleNumber] < startPeople && !MemoizationMap[selectionList[peopleNumber]]) {
				endFlag = true;
				makeTeamFlag = false;
				return startPeople;
			}
			DFS(selectionList, visitedMap, selectionList[peopleNumber]);
		} // CallDFS

		if (!endFlag) {
			endFlag = true;
			if (selectionList[peopleNumber] == startPeople) {
				MemoizationMap[startPeople] = true;
				makeTeamFlag = true;
			} else {
				MemoizationMap[startPeople] = false;
				makeTeamFlag = false;
			}
		} // checkMakeTeam

		visitedMap[peopleNumber] = false;
		if (makeTeamFlag) {
			makeTeam[peopleNumber] = 0;
			return 0;
		} else {
			return startPeople;
		}

	}// DFSMethod()

}// class