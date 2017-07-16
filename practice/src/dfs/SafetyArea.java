package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SafetyArea {

	static boolean[][] visitedSafetyMap;
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dfs/SafetyArea.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfMap = sc.nextInt(); 
			int[][] safetyMap = new int[sizeOfMap][sizeOfMap];
			int maxOfInput = 0;
			int minOfInput = Integer.MAX_VALUE;
			int resultData = 0;
			
			for(int i=0; i<sizeOfMap; i++){
				for(int j=0; j<sizeOfMap; j++){
					safetyMap[i][j] = sc.nextInt();
					//최대 
					if(safetyMap[i][j] > maxOfInput){
						maxOfInput = safetyMap[i][j];
					}	
					//최소
					if(safetyMap[i][j] < minOfInput){
						minOfInput = safetyMap[i][j];
					}
				}
			}//forSetting
			
			for( ; minOfInput <= maxOfInput ; minOfInput++ ){
				int safetyCount = 0; 
				visitedSafetyMap = new boolean[sizeOfMap][sizeOfMap];
				
				for(int i=0; i<sizeOfMap; i++){
					for(int j=0; j<sizeOfMap; j++){
						if(minOfInput < safetyMap[i][j] && !visitedSafetyMap[i][j]){
							safetyCount++;
							Dfs(safetyMap, i, j, minOfInput);
						}
					}
				}//forCountDfs
				
				visitedSafetyMap = null;
				if(resultData < safetyCount){
					resultData = safetyCount;
				}
			}//for1toNSearch
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case+ " " + resultData);
			
			
		}//forTestCase
	}//main

	private static void Dfs(int[][] safetyMap, int i, int j, int minOfInput) {
		visitedSafetyMap[i][j] = true;
		
		//상
		if(i-1 >-1&& minOfInput < safetyMap[i][j] && !visitedSafetyMap[i-1][j]){
			Dfs(safetyMap, i-1, j, minOfInput);
		}
		
		//하
		if(i+1<safetyMap.length && minOfInput < safetyMap[i][j] && !visitedSafetyMap[i+1][j]){
			Dfs(safetyMap, i+1, j, minOfInput);
		}
		
		//좌
		if(j-1 >-1&& minOfInput < safetyMap[i][j] && !visitedSafetyMap[i][j-1]){
			Dfs(safetyMap, i, j-1, minOfInput);
		}
		
		//우
		if(j+1 <safetyMap[0].length && minOfInput < safetyMap[i][j] && !visitedSafetyMap[i][j+1]){
			Dfs(safetyMap, i, j+1, minOfInput);
		}
		
		
	}

}//class