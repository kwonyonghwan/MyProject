package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTest2 {
	
	static int[][] ad;
	static boolean[] visit;
	static int Nv, Ne;
	
	public static void bfs(int i){
		Queue<Integer> q = new <Integer> LinkedList();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		q.offer(i);
		
		while(!q.isEmpty()){
			int temp = q.poll();
			visit[temp] = true;
			System.out.println(temp);
			
			for(int j = 1; j <= Ne; j++){
				if(ad[temp][j] == 1 && visit[j] == false){
					if(!hash.containsKey(j)){
						q.offer(j);
						hash.put(j, true);
					}
				}
						
			}//for
			
		}//while
		
	}//bfs
	
	public static void main(String[] args) {

			Scanner scan = new Scanner(System.in);
			Ne = scan.nextInt();
			Nv = scan.nextInt();
			
			ad = new int[Nv+1][Nv+1];
			visit = new boolean[Nv+1];
			
			for(int i = 0; i<Nv; i++){
				int t1,t2;
				t1 = scan.nextInt();
				t2 = scan.nextInt();
				
				ad[t1][t2] = ad[t2][t1] = 1;
			}
			
			bfs(1);
	
	}//main

}//class
