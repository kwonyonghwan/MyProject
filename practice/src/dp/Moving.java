package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Moving {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dp/moving.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] bottomUpMap = new int[N][M];

			for(int i=0; i<N; i++){
				 for(int j=0; j<M; j++){
					 bottomUpMap[i][j] = sc.nextInt();
				 }
			}
			
			for(int i=1; i<N; i++){
				bottomUpMap[i][0] += bottomUpMap[i-1][0];
			}
			for(int j=1; j<M; j++){
				bottomUpMap[0][j] += bottomUpMap[0][j-1];
			}
			
			for(int i=1; i<N; i++){
				 for(int j=1; j<M; j++){
					 int temp= bottomUpMap[i-1][j];
					 
					 if(temp < bottomUpMap[i][j-1]){
						 temp = bottomUpMap[i][j-1];
					 }
					 if(temp < bottomUpMap[i-1][j-1]){
						 temp = bottomUpMap[i-1][j-1];
					 }
					 bottomUpMap[i][j] +=temp;
				 }
			}
			
			
			for(int i=0; i<N; i++){
				 for(int j=0; j<M; j++){
					 System.out.print(bottomUpMap[i][j]+" ");
					 
				 }
				 System.out.println();
			}
			
			
			

			// 이 부분에서 정답을 출력하십시오.
			System.out.println();
			System.out.println("Case #" + test_case + " "+bottomUpMap[N-1][M-1]);
		}//forTest
		
	}// main

}// class
