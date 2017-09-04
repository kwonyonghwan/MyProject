package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.management.Query;
import javax.swing.text.Position.Bias;

public class BFSAndDFS2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/BFSAndDFS.txt"));
		// Scanner sc = new Scanner(System.in);

		int countOfVertex = sc.nextInt() + 1;
		int countOfEdge = sc.nextInt();
		int startNode = sc.nextInt();

		boolean[][] graph = new boolean[countOfVertex][countOfVertex];
		boolean[] visitedgraph = new boolean[countOfVertex];

		for (int i = 0; i < countOfEdge; i++) {
			int positionA = sc.nextInt();
			int positionB = sc.nextInt();
			graph[positionA][positionB] = graph[positionB][positionA] = true;
		} // forSetting

		visitedgraph[startNode] = true;
		System.out.println();
		for (int i = 0; i < countOfVertex; i++) {
			visitedgraph[i] = false;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		visitedgraph[startNode] = true;
		queue.offer(startNode);

		while (!queue.isEmpty()) {
			int nowVertex = queue.poll();
			System.out.print(nowVertex + " ");

			for (int i = 1; i < graph.length; i++) {
				if (graph[nowVertex][i] && !visitedgraph[i]) {
					visitedgraph[i] = true;
					queue.offer(i);
				}
			}
		} // whileBFS

	}// main

	
}// class
