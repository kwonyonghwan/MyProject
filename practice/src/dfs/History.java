package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class History {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/History.txt"));

		// Scanner sc = new Scanner(System.in);
		
		int countOfVertex = sc.nextInt()+1;
		int countOfEdge = sc.nextInt();
		int[] graph = new int[401];
		ArrayList<ArrayList<Integer>> edgeList = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<401; i++){
			edgeList.add(new ArrayList<Integer>());
			graph[i] = Integer.MIN_VALUE;
		}
		
		for(int i=0; i<countOfEdge; i++){
			edgeList.get(sc.nextInt()).add(sc.nextInt());
		}//forSetting
		
		for(int i=1; i<countOfVertex; i++){
			for(int index=0; index<edgeList.get(i).size(); index++){
				
				if(graph[i]==Integer.MIN_VALUE && graph[edgeList.get(i).get(index)]==Integer.MIN_VALUE){
					//둘다 방문 안했을 경우 
					//앞0 뒤1
					graph[i] =0; 
					graph[edgeList.get(i).get(index)]=1;
					continue;
					
				}else if( graph[edgeList.get(i).get(index)]==Integer.MIN_VALUE){
					//뒤 방문 안했을 경우 
					//걍++
					graph[edgeList.get(i).get(index)] = graph[i]+1;
					continue;
					
				}else if(graph[i]==Integer.MIN_VALUE){
					//앞 방문 안했을 경우 
					//앞0 뒤dfs호출 하며 1++
					if(graph[edgeList.get(i).get(index)]>0){
					graph[i]=graph[edgeList.get(i).get(index)]-1;
					continue;
					}
					
					else{//if(graph[edgeList.get(i).get(index)]==0)
						
					graph[i] = 0;
					
					Queue<Integer> queue = new LinkedList<Integer>();
					graph[edgeList.get(i).get(index)]=1;
					 queue.add(edgeList.get(i).get(index));
					
					 while(!queue.isEmpty()){
						 int nowPosition = queue.poll();
						 
						 for(int j=0; j<edgeList.get(nowPosition).size(); j++){
							 graph[edgeList.get(nowPosition).get(j)]= graph[nowPosition]+1;
							 queue.add(edgeList.get(nowPosition).get(j));
						 }
					 }
					 continue;
					}//if(graph[edgeList.get(i).get(index)]==0)
					
				}else{
					//둘다 방문 
					if(graph[i]>=graph[edgeList.get(i).get(index)]){
						//뒤 돌면서 ++
						Queue<Integer> queue = new LinkedList<Integer>();
						graph[edgeList.get(i).get(index)] = graph[i]+1;
						 queue.add(edgeList.get(i).get(index));
						
						 while(!queue.isEmpty()){
							 int nowPosition = queue.poll();
							 
							 for(int j=0; j<edgeList.get(nowPosition).size(); j++){
								 graph[edgeList.get(nowPosition).get(j)] = graph[nowPosition]+1;
								 queue.add(edgeList.get(nowPosition).get(j));
							 }
						 }
						 continue;
					}
					
				}
				
			}//forIndex
		}//forI
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {
			
			int startVetex = sc.nextInt();
			int endVertex = sc.nextInt();
			
			if(graph[startVetex]==Integer.MIN_VALUE || graph[endVertex]==Integer.MIN_VALUE || graph[startVetex]== graph[endVertex]){
				System.out.println(0);
				continue;
			}else if(graph[startVetex]<graph[endVertex]){
				System.out.println(-1);
				continue;
			}else{
				System.out.println(1);
			}
			
		}//forTestCase

	}//main
}//class
