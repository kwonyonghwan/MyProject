package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class dfsTest2 {

	static boolean[] visitVertex;
	static int[][]graph;
	static int  min;
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(new FileInputStream("src/dfs/input_sample.txt"));
		
		
		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
		
		int numberOfVertex = sc.nextInt();
		graph = new int[numberOfVertex+1][numberOfVertex+1];
		visitVertex = new boolean[numberOfVertex+1];
		min = numberOfVertex*numberOfVertex;
		
		for(int i=1; i<numberOfVertex+1; i++){
			for(int j=1; j<numberOfVertex+1; j++){
				graph[i][j] = sc.nextInt();
			}
		}
		
		DFS(1, 1, 1);
		
		System.out.println(min);
		
		}//for (test_case = 1; test_case <= T; test_case++)
		
	}//main

	private static void DFS(int x, int y, int distance) {
	
		if(x==visitVertex.length-1 && y==visitVertex.length-1){
			if(min > distance){
				min = distance;
			}
		}
		
		graph[y][x] = 0;
		
		if(y>0 && graph[y-1][x] != 0){
			DFS(x, y-1, distance+1);
		}
		if(y<visitVertex.length-1 && graph[y+1][x] != 0){
			DFS(x, y+1, distance+1);
		}
		if(x>0 && graph[y][x-1] != 0){
			DFS(x-1, y, distance+1);
		}
		if(x<visitVertex.length-1 && graph[y][x+1] != 0){
			DFS(x+1, y, distance+1);
		}
		
		graph[y][x]	= 1;
		
	}//DFS

}//class
