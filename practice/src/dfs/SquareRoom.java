package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithm.Position;
/*
class Position { int positionI; int positionJ;

public Position(int i, int j) { this.positionI = i; this.positionJ = j; }

}
*/
public class SquareRoom {
	static int[][] directList = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
	static int[] result;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/SquareRoom.txt"));
		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfSquare = sc.nextInt() + 2;
			int[][] graph = new int[sizeOfSquare][sizeOfSquare];
			boolean[][] visitiedMap = new boolean[sizeOfSquare][sizeOfSquare];
			
			result = new int[2];
			
			for (int i = 1; i < sizeOfSquare - 1; i++) {
				for (int j = 1; j < sizeOfSquare - 1; j++) {
					graph[i][j] = sc.nextInt();
				}
			}//forSetting

			
			for (int i = 1; i < sizeOfSquare - 1; i++) {
				for (int j = 1; j < sizeOfSquare - 1; j++) {
					DFS(i, j, graph, visitiedMap, 0, graph[i][j]);
				}
			}//DFSAll

			System.out.println("#"+test_case+" "+result[1]+" "+result[0]);
		} // forTestCase

	}// main

	public static void DFS(int positionI, int positionJ, int[][] graph, boolean[][] visitiedMap, int step, int startNumber) {

		visitiedMap[positionI][positionJ]=true;
		step++;
		
		for(int i=0; i<4; i++){
			Position nextPosition = new Position(positionI+directList[i][0], positionJ+directList[i][1]);
			if(graph[nextPosition.positionI][nextPosition.positionJ]-1==graph[positionI][positionJ]&&!visitiedMap[nextPosition.positionI][nextPosition.positionJ]){
				DFS(nextPosition.positionI, nextPosition.positionJ, graph, visitiedMap,step,startNumber);
			}
		}//forNextStep
		
		if(step==result[0]&&startNumber<result[1]){
			result[1]=startNumber;
		}else if(step>result[0]){
			result[1]=startNumber;
			result[0]=step;
		}
		
		visitiedMap[positionI][positionJ]=false;
		
	}// DFSMethod()

}// class