package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KevinBaconSixStepRule2 {
	static int resultDistance;
	static int resultPeopleNumber;

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dfs/KevinBaconSixStepRule.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			resultDistance = Integer.MAX_VALUE;
			int numberOfUser = sc.nextInt()+1;
			int numberOfNetwork = sc.nextInt();
			boolean[][] networkMap = new boolean[numberOfUser][numberOfUser];
			
			for(int i=0; i<numberOfNetwork; i++){
				int peopleOfA = sc.nextInt();
				int peopleOfB = sc.nextInt();
				networkMap[peopleOfA][peopleOfB] = 	networkMap[peopleOfB][peopleOfA] = true; 			
			}//forSetting
			
			for(int i=1; i<numberOfUser; i++){
				int[] distanceList = new int[numberOfUser];
				int KevinBaconSum = 0;
				for(int j=1; j<numberOfUser; j++){
					distanceList[j] = -1;
				}
				distanceList[i] = 0;
				dfs(i, distanceList, networkMap);
				
				for(int j=1; j<numberOfUser; j++){
					KevinBaconSum += distanceList[j];
					}
				
				if(resultDistance > KevinBaconSum){
					resultDistance = KevinBaconSum;
					resultPeopleNumber = i;
				}
				
				distanceList =null;
			}//dfsAll()
			

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+ resultPeopleNumber);
			
		}//forTest
		
	}// main

	private static void dfs(int startPeople, int[] distanceList, boolean[][] networkMap) {
		
		for(int i =1; i<networkMap.length; i++){
			if(distanceList[i]<0 && networkMap[startPeople][i]){
				distanceList[i] = distanceList[startPeople]+1;
				dfs(i, distanceList, networkMap);
			}
		}
		
	}//dfs()

}// class
