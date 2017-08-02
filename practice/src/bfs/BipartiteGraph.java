package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BipartiteGraph {
	static boolean noFlag = false;

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/BipartiteGraph.txt"));
		//Scanner sc = new Scanner(System.in);
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int countOfVertex = sc.nextInt()+1;
			int countOfEdge = sc.nextInt();
			noFlag = false;

			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			int[] indexGraph = new int[countOfVertex];
			
			for(int i=0; i<countOfVertex; i++){
				graph.add(new ArrayList());
				indexGraph[i] = -1;
			}
			for(int i=0; i<countOfEdge; i++){
				int positionI = sc.nextInt();
				int positionJ = sc.nextInt();
				graph.get(positionI).add(positionJ);
				graph.get(positionJ).add(positionI);
			}//forSetting
			
			String checkBipartiteGraph="";
			for (ArrayList<Integer> startVertex : graph) {
				if(!startVertex.isEmpty()){
					checkBipartiteGraph = DFS(startVertex.get(0), indexGraph, graph,0);
				}
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " "+ checkBipartiteGraph);
		}//forTest
		
	}

	private static String DFS(int startVertex, int[] indexGraph, ArrayList<ArrayList<Integer>> graph, int setIndex) {
		
		int nextVertex = 0;
		if(indexGraph[startVertex]>-1 && indexGraph[startVertex] != setIndex){
			noFlag = true;
		}
		
		indexGraph[startVertex] = setIndex;
		
		while(!graph.get(startVertex).isEmpty()){
			
			nextVertex=graph.get(startVertex).get(0);
			graph.get(startVertex).remove(0);
			DFS(nextVertex,indexGraph, graph, (setIndex+1)%2);
			
		}//whileNextStep
		
		if(noFlag){
			return "NO";
		}else{
			return "YES";
		}
		
	}

}//