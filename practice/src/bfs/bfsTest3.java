package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsTest3 {
	
	static ArrayList<ArrayList<Integer>> ad;
	static boolean[] visit;
	static int Ne, Nv;
	
	public static void bfs(int i){
		Queue<Integer> q = new <Integer> LinkedList();
		HashMap<Integer, Boolean> hash = new HashMap<Integer, Boolean>();
		
		q.offer(i);
		
		while(!q.isEmpty()){
			
			int temp = q.poll();
			visit[temp] = true;
			System.out.println(temp);
			
			for(int j :ad.get(temp)){
				if(visit[j] == false && !hash.containsKey(j)){
					q.offer(j);
					hash.put(j, true);
				}
			}
			
		}//while
		
	}//bfs
	

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Nv = scan.nextInt();
		Ne = scan.nextInt();
		ad = new<ArrayList<Integer>> ArrayList(Nv+1);
		visit = new boolean[Nv+1];
		
		for(int i =0; i< Nv+1; i++){
			int t1, t2;
			t1 = scan.nextInt();
			t2 = scan.nextInt();
			
			ad.get(t1).add(t2);
			ad.get(t2).add(t1);
			
		}//for
		
		bfs(1);
		
	}//main

}//class
