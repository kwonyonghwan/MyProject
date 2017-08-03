package bfs;

import java.beans.Visibility;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hideAndSeek {
	static int maxValue = 100001;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int startLocation = 5;
		int endLocation = 17;

		int[] graph = new int[maxValue];
		for(int i=0; i<maxValue; i++){
			graph[i]= -1;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		graph[startLocation] = 0;
		queue.offer(startLocation);

		while (!queue.isEmpty()) {
			
			int nowLocation = queue.poll();
			System.out.println(queue.toString());

			if ((nowLocation - 1) > -1 && graph[nowLocation - 1] < 0) {
				graph[nowLocation - 1] = graph[nowLocation] + 1;
				queue.offer(nowLocation - 1);
			}

			if ((nowLocation + 1) < maxValue && graph[nowLocation + 1] < 0) {
				graph[nowLocation + 1] = graph[nowLocation] + 1;
				queue.offer(nowLocation + 1);
			}

			if ((nowLocation * 2) < maxValue && graph[nowLocation * 2] < 0) {
				graph[nowLocation * 2] = graph[nowLocation] + 1;
				queue.offer(nowLocation * 2);
			}

			if ((nowLocation-1) == endLocation ||(nowLocation+1) == endLocation ||(nowLocation*2) == endLocation ) {
				break;
			}
		} // whileBFS

		System.out.println(graph[endLocation]);

	}// main

}// class
