package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CrazyRobot {
	//동0 서1 남2 북3
	static double[] propabilityList = new double[4];
	static int[][] directionList = { { 0, 1 }, { 0, -1 }, { +1, 0 }, { -1, 0 } };
	static double resultPropability;
	static int lastStep;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/dfs/CrazyRobot.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			lastStep = sc.nextInt();
			int[][] graph = new int[(2*lastStep)+1][(2*lastStep)+1];
			boolean[][] visitedGraph = new boolean[(2*lastStep)+1][(2*lastStep)+1];
			for(int i=0; i<4; i++){
				propabilityList[i] = sc.nextDouble() /100;
			}
	
			dfs(lastStep, lastStep, 1, 0, visitedGraph);
			
			// 이 부분에서 정답을 출력하십시오. 
			System.out.println("Case #" + test_case + " "+resultPropability);
		}//forTest
		
	}// main

	private static void dfs(int positionI, int positionJ, double propavility, int step, boolean[][] visitedGraph) {

		visitedGraph[positionI][positionJ] = true;
		step++;
		if(step==lastStep+1){
			resultPropability += propavility;
			visitedGraph[positionI][positionJ] = false;	
			return;
		}
		
		for(int i=0; i<4; i++){
			if(!visitedGraph[positionI+directionList[i][0]][positionJ+directionList[i][1]]){
				dfs(positionI+directionList[i][0], positionJ+directionList[i][1], propavility*propabilityList[i], step, visitedGraph);
			}
		}
		visitedGraph[positionI][positionJ] = false;	
	}//dfs()

}// class
