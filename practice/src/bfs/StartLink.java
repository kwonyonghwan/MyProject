package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StartLink {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/bfs/StartLink.txt"));

		//Scanner sc = new Scanner(System.in);

		int totalStair = sc.nextInt();
		int startPosition = sc.nextInt();
		int endPosition = sc.nextInt();
		int upStair = sc.nextInt();
		int downStair = sc.nextInt();
		
		if(startPosition==endPosition){
			System.out.println(0);
			return;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visitiedMap = new boolean[1000001];

		visitiedMap[startPosition] = true;
		queue.add(startPosition);
		int step = -1;
		
		while (!queue.isEmpty()) {
			
			step++;
			int queueSize = queue.size();
			
			for (int i = 0; i < queueSize; i++) {

				int nowPosition = queue.poll();
				
				if(nowPosition+upStair<=endPosition && !visitiedMap[nowPosition+upStair]){
					visitiedMap[nowPosition+upStair]=true;
					queue.add(nowPosition+upStair);
				}
				
				if(nowPosition-downStair>0 && !visitiedMap[nowPosition-downStair]){
					visitiedMap[nowPosition-downStair]=true;
					queue.add(nowPosition-downStair);
				}

				if(visitiedMap[endPosition]){
					System.out.println(step+1);
					queue.clear();
					break;
				}
				
			} // forStep
			
		} // whileBFS

		if(!visitiedMap[endPosition]){
			System.out.println("use the stairs");
		}

	}// main

}// class
