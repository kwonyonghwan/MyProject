/*package shortestPath;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Vertex implements Comparable<Vertex> {
	int vertex;
	int weight;

	public Vertex(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex target) {
		if (this.weight > target.weight) {
			return 1;
		} else if (this.weight < target.weight) {
			return -1;
		}
		return 0;
	}

}// Node

public class SpecificRoute2 {

	static ArrayList<ArrayList> graph = new ArrayList<ArrayList>();
	// 0 : 1->A 1 : 1->B 2 : A->B 3 : A->N 4 : B->N
	static ArrayList<Integer> resultList = new ArrayList<Integer>();
	static int[] startVertexList = new int[3];

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int countOfVertex = sc.nextInt() + 1;
		int countOfEdge = sc.nextInt();

		for (int i = 0; i < countOfVertex; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < countOfEdge; i++) {
			int tempA = sc.nextInt();
			int tempB = sc.nextInt();
			int tempWeight = sc.nextInt();
			
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(tempB);
			temp.add(tempWeight);			
			graph.get(tempA).add(temp);
			
			ArrayList<Integer> temp2 = new ArrayList<>();
			temp2.add(tempA);
			temp2.add(tempWeight);			
			graph.get(tempB).add(temp2);
		}

		int vertexA = sc.nextInt();
		int vertexB = sc.nextInt();

		startVertexList[0] = 1;
		startVertexList[1] = vertexA;
		startVertexList[2] = countOfVertex - 1;

		for (int i = 0; i < 3; i++) {
			if (!Dijkstra(i, vertexA, vertexB)) {
				System.out.println(-1);
				return;
			}
		}

		// 4���� ���
		int tempA = Math.min((resultList.get(0) + resultList.get(2) + resultList.get(4)),
				(resultList.get(0) + resultList.get(2) * 2 + resultList.get(3)));
		int tempB = Math.min((resultList.get(1) + resultList.get(2) + resultList.get(3)),
				(resultList.get(1) + resultList.get(2) * 2 + resultList.get(4)));

		System.out.println(Math.min(tempA, tempB));

	}// main

	public static boolean Dijkstra(int startIndex, int vertexA, int vertexB) {

		PriorityQueue<Vertex> prioriQueue = new PriorityQueue<>();
		prioriQueue.add(new Vertex(startVertexList[startIndex], 0));

		boolean[] visitiedMap = new boolean[graph.size()];
		int[] distanceMap = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			distanceMap[i] =Integer.MAX_VALUE / 2;
		}
		distanceMap[startVertexList[startIndex]] = 0;

		while(!prioriQueue.isEmpty()) {
			Vertex nowVertex = prioriQueue.poll();
			visitiedMap[nowVertex.vertex] = true;

			if (visitiedMap[vertexA] && visitiedMap[vertexB]) {
				break;
			}
	
			for (int i = 0; i < graph.get(nowVertex.vertex).size(); i++) {
				ArrayList<Integer> temp = (ArrayList<Integer>) graph.get(nowVertex.vertex).get(i);
				if(!visitiedMap[temp.get(0)] ){
					if(distanceMap[temp.get(0)] > distanceMap[nowVertex.vertex]+temp.get(1)){
						distanceMap[temp.get(0)] = distanceMap[nowVertex.vertex]+ temp.get(1);
						Vertex nextVertex = new Vertex(temp.get(0), distanceMap[temp.get(0)]);
						prioriQueue.offer(nextVertex);
					}
					
				}
			} // for

		} // while

		if (((startIndex == 1) && (distanceMap[vertexB] > 200000000)
				|| (distanceMap[vertexA] > 200000000 && distanceMap[vertexB] > 200000000))) {
			return false;
		}

		if (startIndex == 1) {
			resultList.add(distanceMap[vertexB]);
		} else {
			resultList.add(distanceMap[vertexA]);
			resultList.add(distanceMap[vertexB]);
		}

		return true;
	}// Dijkstra

}// class
*/