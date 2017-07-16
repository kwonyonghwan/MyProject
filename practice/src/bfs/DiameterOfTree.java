package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiameterOfTree {

	static int max;
	static int maxPosition;
	static Queue<Integer> queue;

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/bfs/DiameterOfTree.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfNode = sc.nextInt() + 1;
			
			ArrayList<ArrayList> graphTemp = new ArrayList<ArrayList>(numberOfNode);
			for (int i = 0; i < numberOfNode; i++) {
				graphTemp.add(new ArrayList<Integer>());
			}

			while (sc.hasNext()) {

				int startNode = sc.nextInt();
				int endNode = sc.nextInt();
				int weight = sc.nextInt();

				ArrayList<Integer> startTemp = new ArrayList<Integer>();
				startTemp.add(endNode);
				startTemp.add(weight);

				ArrayList<Integer> endTemp = new ArrayList<Integer>();
				endTemp.add(startNode);
				endTemp.add(weight);

				graphTemp.get(startNode).add(startTemp);
				graphTemp.get(endNode).add(endTemp);

			} // inputSetting

			max = 0;
			maxPosition = 0;
			queue = new LinkedList<Integer>();
			queue.offer(1);
			BFS(graphTemp);

			queue.offer(maxPosition);
			BFS(graphTemp);

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + max);
		} // forTest

	}// main

	public static void BFS(ArrayList<ArrayList> graphTemp) {

		int[] distance = new int[graphTemp.size()];
		boolean[] visitedMap = new boolean[graphTemp.size()];

		while (!queue.isEmpty()) {

			int currentTemp = queue.poll();
			visitedMap[currentTemp] = true;

			for (int i = 0; i < graphTemp.get(currentTemp).size(); i++) {
				ArrayList<Integer> tempArray = (ArrayList<Integer>) graphTemp.get(currentTemp).get(i);

				if (!visitedMap[tempArray.get(0)]) {
					queue.offer(tempArray.get(0));
					distance[tempArray.get(0)] = distance[currentTemp] + tempArray.get(1);

					if (max < distance[tempArray.get(0)]) {
						max = distance[tempArray.get(0)];
						maxPosition = tempArray.get(0);
					}
					
				}
			}//OneStepOfBfs

		} //whileBFS

	}// MethodBFS()

}// class
