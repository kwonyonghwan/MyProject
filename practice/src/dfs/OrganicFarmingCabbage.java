package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OrganicFarmingCabbage {
	static int[][] directionMove = { { -1, 0 }, { 0, +1 }, { +1, 0 }, { 0, -1 } };
	static int numberOfM;
	static int numberOfN;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/OrganicFarmingCabbage.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			 numberOfM = sc.nextInt();
			 numberOfN = sc.nextInt();
			int countOfWarm = 0;
			
			int[][] graph= new int[51][51];
			boolean[][] visitedGraph = new boolean[51][51];
			int countOfCabbage = sc.nextInt();
			
			for(int i=0; i<countOfCabbage; i++){
				int temp = sc.nextInt();
				graph[sc.nextInt()][temp] = 1;
			}//forSetting
			
			for(int i=0; i<numberOfN; i++){
				for(int j=0; j<numberOfM; j++){
					if(graph[i][j]==1&& !visitedGraph[i][j]){
						countOfWarm++;
						bfs(graph, visitedGraph, i, j);
					}
				}
			}
			
			System.out.println(countOfWarm);
		}//forTest
		
	}//main

	private static void bfs(int[][] graph, boolean[][] visitedGraph, int positionI, int positionJ) {
		
		Positon tempPosition = new Positon(positionI, positionJ);
		Queue<Positon> queue = new LinkedList<Positon>();
		queue.offer(tempPosition);
		
		while(!queue.isEmpty()){
			Positon nowPosition = queue.poll();
			visitedGraph[nowPosition.I][nowPosition.J]=true;
			
			for(int i=0; i<4; i++){
				Positon nextPosition = new Positon(nowPosition.I+directionMove[i][0], nowPosition.J+directionMove[i][1]);
				if(nextPosition.I >-1
						&& nextPosition.I<numberOfN
						&& nextPosition.J>-1
						&& nextPosition.J<numberOfM
						&& graph[nextPosition.I][nextPosition.J]==1
						&& !visitedGraph[nextPosition.I][nextPosition.J]){
					queue.offer(nextPosition);
				}
					
			}//forNextPosition
			
		}//whileBFS
		
	}//main
	
}// class

class Positon {
	int I;
	int J;

	public Positon(int i, int j) {
		this.I = i;
		this.J = j;
	}
}




