package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MakeBridge {

	static int[][] bottomUp = new int[31][31];
	static boolean makeCheck;
	public static void main(String[] args) throws FileNotFoundException {
		
		if(!makeCheck){
			for(int i=1; i<bottomUp[0].length; i++){
				bottomUp[1][i] = i;
			}//forSettingIndexI=1
			
			for(int i=2; i<bottomUp.length;i++){
				for(int j=i; j<bottomUp[0].length; j++){
					if(i==j){
						bottomUp[i][j]=1;
						continue;
					}//forSettingIndexI=IndexJ
					bottomUp[i][j] = bottomUp[i][j-1]+ bottomUp[i-1][j-1];
				}//forSettingOther
			}
		
			makeCheck = true;
		}//makeBottomUp
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/MakeBridge.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + bottomUp[sc.nextInt()][sc.nextInt()]);
		}//forTest
		
	}// main

}// class
