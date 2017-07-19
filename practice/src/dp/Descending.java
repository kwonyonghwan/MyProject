package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Descending {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Descending.txt"));
		//Scanner sc = new Scanner(System.in);

		int sizeOfGraph = sc.nextInt();
		int[][] graph = new int[sizeOfGraph][3];
		int[][] maxBottomUpMap = new int[sizeOfGraph][3];
		int[][] minBottomUpMap = new int[sizeOfGraph][3];

		for(int i=0; i<sizeOfGraph; i++){
			for(int j=0; j<3; j++){
				graph[i][j] = sc.nextInt();
			}
		}//forSetting
		
		maxBottomUpMap[0][0] = minBottomUpMap[0][0] = graph[0][0];
		maxBottomUpMap[0][1] = minBottomUpMap[0][1] = graph[0][1];
		maxBottomUpMap[0][2] = minBottomUpMap[0][2] = graph[0][2];
	
		for(int i=1; i<sizeOfGraph; i++){
			
			maxBottomUpMap[i][0] = Math.max(maxBottomUpMap[i-1][0], maxBottomUpMap[i-1][1])+graph[i][0];
			maxBottomUpMap[i][2] = Math.max(maxBottomUpMap[i-1][1], maxBottomUpMap[i-1][2])+graph[i][2];
	
			int temp = Math.max(maxBottomUpMap[i-1][0], maxBottomUpMap[i-1][1]);
			temp = Math.max(temp, maxBottomUpMap[i-1][2]);
			maxBottomUpMap[i][1] = temp+graph[i][1];
			
			
			minBottomUpMap[i][0] = Math.min(minBottomUpMap[i-1][0], minBottomUpMap[i-1][1])+graph[i][0];
			minBottomUpMap[i][2] = Math.min(minBottomUpMap[i-1][1], minBottomUpMap[i-1][2])+graph[i][2];
			
			int temp1 = Math.min(minBottomUpMap[i-1][0], minBottomUpMap[i-1][1]);
			temp1 = Math.min(temp1, minBottomUpMap[i-1][2]);
			minBottomUpMap[i][1] = temp1+graph[i][1];
		}//forMakeBottomUp
	
		int minResult = Integer.MAX_VALUE;
		int maxResult = Integer.MIN_VALUE;
	
		for(int i=0; i<3; i++){
			minResult = Math.min(minResult, minBottomUpMap[sizeOfGraph-1][i]);
			maxResult = Math.max(maxResult, maxBottomUpMap[sizeOfGraph-1][i]);
		}
		System.out.println(maxResult+" "+ minResult);
		
	}//main

}//class
