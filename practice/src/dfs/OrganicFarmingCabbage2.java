package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OrganicFarmingCabbage2 {
	
	static int numberOfM ;
	static int numberOfN ;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/OrganicFarmingCabbage.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			numberOfM = sc.nextInt();
			numberOfN = sc.nextInt();
			int countOfCabbage = sc.nextInt();
			int resultCount = 0;

			boolean[][] cabbageMap = new boolean[50][50];

			for (int i = 0; i < countOfCabbage; i++) {
				int temp = sc.nextInt();
				cabbageMap[sc.nextInt()][temp] = true;
			}//forSetting

			for (int i = 0; i<numberOfN; i++) {
				for (int j = 0; j<numberOfM; j++) {
					if (cabbageMap[i][j]) {
						resultCount++;
						dfsCabbage(i, j, cabbageMap);
					}
				}
			} // DFSALL

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + resultCount);
		}//forTest

	}// main

	private static void dfsCabbage(int positionI, int positionJ, boolean[][] cabbageMap) {

		cabbageMap[positionI][positionJ] = false;

		// 상
		if (positionI - 1 >-1 && cabbageMap[positionI - 1][positionJ]) {
			dfsCabbage(positionI - 1, positionJ, cabbageMap);
		}
		// 하
		if (positionI + 1 < numberOfN && cabbageMap[positionI + 1][positionJ]) {
			dfsCabbage(positionI + 1, positionJ, cabbageMap);
		}
		// 좌
		if (positionJ - 1 > -1 && cabbageMap[positionI][positionJ - 1]) {
			dfsCabbage(positionI, positionJ - 1, cabbageMap);
		}
		// 우
		if (positionJ + 1 < numberOfM && cabbageMap[positionI][positionJ + 1]) {
			dfsCabbage(positionI, positionJ + 1, cabbageMap);
		}

	}// dfsCabbage

}// class
