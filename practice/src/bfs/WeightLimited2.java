package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


class Island implements Comparable<Island>{
	int islandNumber;
	int islandWeight;
	
	public Island(int vertexNumber, int vertexWeight){
		super();
		this.islandNumber = vertexNumber;
		this.islandWeight = vertexWeight;
	}

	@Override
	public int compareTo(Island target) {
		if(this.islandWeight > target.islandWeight){
			return -1;
		}else if(this.islandWeight < target.islandWeight){
			return 1;
		}
		return 0;
	}
}//ClassVertex


public class WeightLimited2 {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/bfs/WeightLimited.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			int countOfIsland = sc.nextInt()+1;
			int countOfBridge = sc.nextInt();
			ArrayList<ArrayList<Integer>> islandGraph = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0; i<countOfIsland; i++){
				islandGraph.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<countOfBridge; i++){
				int startIsland = sc.nextInt();
				int endIsland = sc.nextInt();
				int weight = sc.nextInt();
				islandGraph.get(startIsland).add(endIsland);
				islandGraph.get(startIsland).add(weight);
				islandGraph.get(endIsland).add(startIsland);
				islandGraph.get(endIsland).add(weight);
			}//forSetting
			
			int startIsland = sc.nextInt();
			int endIsland = sc.nextInt();
			
			PriorityQueue<Island> queue = new PriorityQueue<Island>();
			boolean[] visitedGraph = new boolean[countOfIsland];
			
			Island startVertex = new Island(startIsland, Integer.MAX_VALUE);
			queue.offer(startVertex);
			
			while(!queue.isEmpty()){
				Island nowPosition = queue.poll();
				if(nowPosition.islandNumber==endIsland){
					System.out.println(nowPosition.islandWeight);
					break;
				}
				
				if(visitedGraph[nowPosition.islandNumber]){
					continue;
				}
				visitedGraph[nowPosition.islandNumber] = true;

				for(int i=0; i<islandGraph.get(nowPosition.islandNumber).size(); i= i+2){
					Island nextPosition = new Island( islandGraph.get(nowPosition.islandNumber).get(i), Math.min(nowPosition.islandWeight, islandGraph.get(nowPosition.islandNumber).get(i+1)));
					queue.offer(nextPosition);
				}//forNextStep
				
			}//whileBFS

		}//forTest
		
	}// main

}// class
