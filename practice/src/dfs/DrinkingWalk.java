package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithm.PrintGraph;

public class DrinkingWalk {

	static int[][] graph;
	static boolean findEndPosition=false;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/DrinkingWalk.txt"));

		// Scanner sc = new Scanner(System.in);
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int countOfMarket = sc.nextInt()+2;
			
			graph = new int[countOfMarket][countOfMarket];
			
			int[] positionList = new int[countOfMarket*2];
			
			for(int i=0; i<countOfMarket*2; i++	){
				positionList[i] = sc.nextInt();
			}
			
			for(int i=0; i<countOfMarket; i++){
				for(int j=i; j<countOfMarket; j++){
					graph[i][j] = graph[j][i] = Math.abs(positionList[i*2] -positionList[j*2]) + Math.abs(positionList[i*2+1] -positionList[j*2+1]);
				}
			}
			boolean[] visitiedMap = new boolean[countOfMarket];
			visitiedMap[0]=true;
			dfs(0,visitiedMap);
			
			if(visitiedMap[countOfMarket-1]){
				System.out.println("happy");
			}else{
				System.out.println("sad");
			}

		} // forTest

	}// main

	private static void dfs(int startPosition, boolean[] visitiedMap) {

		visitiedMap[startPosition] = true;
		for(int i=0; i<graph.length; i++){
			if(!visitiedMap[i]&& graph[startPosition][i]<1001&&!visitiedMap[graph.length-1]){
				dfs(i, visitiedMap);
			}
		}
		
	}// dfs()

}// class
