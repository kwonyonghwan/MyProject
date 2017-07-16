package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTest1 {
	
	static int[][] graph;
	static boolean[] visit;
	static int Nv, Ne;

	public static void bfs(int i){
		
		Queue<Integer> q = new <Integer> LinkedList();
		
		q.offer(i);
		visit[i] = true;
		
		while(!q.isEmpty()){
			int temp = q.poll();
			System.out.println(temp);
			
			for(int j = 1; j <=Nv; j++ ){
				if(graph[temp][j]==1 && visit[j] == false){
					q.offer(j);
					visit[j] = true;
				}
				
			}//for
			
		}//while
	
	}//bfs
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Nv = scan.nextInt();
		Ne = scan.nextInt();
		graph = new int[Nv+1][Nv+1];
		visit = new boolean[Nv+1];
		
		for(int i = 0; i<Ne; i++){
			int t1, t2;
			t1 = scan.nextInt();
			t2 = scan.nextInt();
			
			graph[t1][t2] = graph[t2][t1] = 1;
		}
		
		bfs(1);
		
	}//main

}//class
