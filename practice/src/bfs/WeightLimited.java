package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WeightLimited {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/bfs/WeightLimited.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			System.out.println(test_case);
			
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
			
			Queue<Integer> queue = new LinkedList<Integer>();
			Queue<Integer> beforeQueue = new LinkedList<Integer>();	
			
			int startIsland = sc.nextInt();
			int endIsland = sc.nextInt();
			int[] weightList = new int[countOfIsland];
			int[] resultWeightList = new int[countOfIsland];
			boolean flag = false;
			weightList[startIsland] = weightList[endIsland] = Integer.MAX_VALUE;
			
			
			queue.offer(startIsland);
			beforeQueue.offer(0);
			while(!queue.isEmpty()){
				int nowPosition = queue.poll();
				int beforPosition = beforeQueue.poll();
			
				for(int i=0; i<islandGraph.get(nowPosition).size(); i= i+2){

					if(beforPosition == islandGraph.get(nowPosition).get(i)){
						continue;
					}
					
					weightList[islandGraph.get(nowPosition).get(i)] = Math.min(islandGraph.get(nowPosition).get(i+1), weightList[nowPosition] );
					resultWeightList[islandGraph.get(nowPosition).get(i)] = Math.max(resultWeightList[islandGraph.get(nowPosition).get(i)], weightList[islandGraph.get(nowPosition).get(i)]);
					weightList[islandGraph.get(nowPosition).get(i)] = Math.max(resultWeightList[islandGraph.get(nowPosition).get(i)], weightList[islandGraph.get(nowPosition).get(i)] );
					
					if(!flag){
						if(nowPosition == endIsland){
							flag = true;
						}
						queue.offer(islandGraph.get(nowPosition).get(i));
						beforeQueue.offer(nowPosition);
					}
				}
			}//whileBFS
			

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+resultWeightList[endIsland]);
		}//forTest
		
	}// main

}// class
