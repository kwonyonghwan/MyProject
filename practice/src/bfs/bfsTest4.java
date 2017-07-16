package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTest4 {

	static int[][] graph;
	static int[] vertexDistance;
	static int[] vertexPredecessor;
	static int numberVertex, numberEdge;

	public static void bfs(int i){
		
		Queue<Integer> q = new <Integer> LinkedList();
		
		int startVertex =  i;
		
		for(int j=0; j<numberVertex+1; j++){
			vertexDistance[j] = -1;
			vertexPredecessor[j] = 0;
		}
		
		vertexPredecessor[startVertex] = 0;
		vertexDistance[startVertex] = 0;
		q.offer(startVertex);
		
		while(!q.isEmpty()){
			int temp = q.poll();
			for(int j=0; j<numberVertex+1; j++){
				if(graph[temp][j] == 1 && vertexDistance[j]== -1){
					vertexDistance[j] = vertexDistance[temp] + 1;
					vertexPredecessor[j] = temp;
					q.offer(j);	
				}
				
			}//for			
			
		}//while
		
	}//bfs
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		numberVertex = scan.nextInt();
		numberEdge = scan.nextInt();
		graph = new int[numberVertex+1][numberVertex+1];
		vertexDistance = new int[numberVertex+1];
		vertexPredecessor = new int[numberVertex+1];
		
		for(int i=0; i<numberEdge; i++){
			int t1, t2;
			t1 = scan.nextInt();
			t2 = scan.nextInt();
			graph[t1][t2] = graph[t2][t1] = 1;		
		}//for
	
		bfs(1);
		
		//1~4까지의 최단 경로
		shortestPath(1 ,4);
		
	}//main

	public static void shortestPath(int s, int v){
		
		if(s == v){
			System.out.println(s);
		}else if(vertexPredecessor == null){
			System.out.println("no path from s to v exists");
		}else{
			shortestPath(s, vertexPredecessor[v]);
			System.out.println(v);
		}
		
	}//printPath
	
	
	
}//class
