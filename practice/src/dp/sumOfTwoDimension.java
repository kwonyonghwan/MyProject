package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sumOfTwoDimension {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/sumOfTwoDimension.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			int numberOfN = sc.nextInt()+1;
			int numberOfM = sc.nextInt()+1;
			int[][] bottomUpGraph = new int[numberOfN][numberOfM];
			
			for(int i=1; i<numberOfN;i++){
				for(int j=1; j<numberOfM; j++){
					bottomUpGraph[i][j] = bottomUpGraph[i-1][j]+bottomUpGraph[i][j-1]+sc.nextInt()-bottomUpGraph[i-1][j-1];	
				}
			}//makeBottomUPMap
			
			int testCaseCount = sc.nextInt();
			for(int i=0; i<testCaseCount; i++){				
				// 이 부분에서 정답을 출력하십시오.
				int startI = sc.nextInt();
				int startJ = sc.nextInt();
				int endI = sc.nextInt();
				int endJ = sc.nextInt();
				
				System.out.println("Case #" + test_case + " " +( bottomUpGraph[endI][endJ]-bottomUpGraph[startI-1][endJ]-bottomUpGraph[endI][startJ-1]+bottomUpGraph[startI-1][startJ-1]) );
			}

		}//forTest
		
	}// main

}// class
