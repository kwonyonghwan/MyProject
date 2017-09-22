/*package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import algorithm.PrintGraph;

class Position {
	int positionI;
	int positionJ;

	public Position(int positionI, int positionJ) {
		this.positionI = positionI;
		this.positionJ = positionJ;
	}

}//class

public class SupplyRoad {

	static int[][] directionList = { { 1, 0 }, { 0, 1 },{-1,0},{0,-1} };

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/SupplyRoad.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_case;
		int T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int sizeOfGraph = sc.nextInt() + 2;
			int[][] graph = new int[sizeOfGraph][sizeOfGraph];
			int[][] resultGraph = new int[sizeOfGraph][sizeOfGraph];
			boolean[][] visitiedGraph = new boolean[sizeOfGraph][sizeOfGraph];

			for (int i = 0; i < sizeOfGraph; i++) {
				graph[i][0] = graph[0][i] = graph[sizeOfGraph - 1][i] = graph[i][sizeOfGraph - 1] = -1;
				for(int j=0; j<sizeOfGraph; j++){
					resultGraph[i][j] = Integer.MAX_VALUE;
				}
			}
			sc.nextLine();
			for (int i = 1; i < sizeOfGraph - 1; i++) {
				String temp = sc.nextLine();
				for (int j = 1; j < sizeOfGraph - 1; j++) {
					graph[i][j] = Character.getNumericValue(temp.charAt(j - 1));
				}
			} // forSetting

			Queue<Position> queue = new LinkedList<>();
			
			queue.offer(new Position(1, 1));
			resultGraph[1][1]=0;
			visitiedGraph[1][1]=true;
			
			while(!queue.isEmpty()){
				
				Position nowPosition = queue.poll();
				visitiedGraph[nowPosition.positionI][nowPosition.positionJ]=true;
				
				for(int i=0; i<4; i++){
					
					Position nextPosition = new Position(nowPosition.positionI+directionList[i][0], nowPosition.positionJ+directionList[i][1]);
					
					if(graph[nextPosition.positionI][nextPosition.positionJ]>-1 && resultGraph[nextPosition.positionI][nextPosition.positionJ]>resultGraph[nowPosition.positionI][nowPosition.positionJ]+graph[nextPosition.positionI][nextPosition.positionJ]){
						resultGraph[nextPosition.positionI][nextPosition.positionJ]= resultGraph[nowPosition.positionI][nowPosition.positionJ]+graph[nextPosition.positionI][nextPosition.positionJ];
						queue.offer(nextPosition);
					}
					
				}
				
			}//whileBFS
			
			System.out.println("#"+test_case+" "+resultGraph[sizeOfGraph-2][sizeOfGraph-2]);
			
		}//forTestCase
	}// main

}// class*/