package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* 사용하는 클래스명이 Solution 이어야 하며, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해 볼 수 있습니다. */

public class happyworld {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 sample_input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		 * 만약 본인의 PC 에서 테스트 할 때는, 입력값을 sample_input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		 * 표준입력 대신 sample_input.txt 파일로 부터 입력값을 읽어 올 수 있습니다. 또한, 본인 PC에서 아래 메소드를
		 * 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다. 단, Codeground 시스템에서 "제출하기" 할 때에는 반드시
		 * 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다.
		 */
		Scanner sc = new Scanner(new FileInputStream("src/bfs/input_sample.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오. 기본 제공된 코드를 수정 또는 삭제하고 본인이 코드를 사용하셔도
			// 됩니다.

			int resultdata = 1;
			//////////////////////////////////////// insert data
			int numberOfVertex = sc.nextInt();
			int numberOfEdge = sc.nextInt();
			int[] vertexDistance = new int[numberOfVertex + 1];
			int[] vertexPredecessor = new int[numberOfVertex + 1];

			int[][] graph = new int[numberOfVertex + 1][numberOfVertex + 1];

			for (int i = 0; i < numberOfEdge; i++) {
				int temp1 = sc.nextInt();
				int temp2 = sc.nextInt();

				graph[temp1][temp2] = 1;
				graph[temp2][temp1] = 1;

			} // for

			//////////////////////////////////////// bfs
			Queue<Integer> bfsQueue = new <Integer>LinkedList();
			int startVertex = 1;
			int longDistance = 0;
			;

			for (int j = 0; j < numberOfVertex + 1; j++) {
				vertexDistance[j] = -1;
				vertexPredecessor[j] = 0;
			}

			vertexPredecessor[startVertex] = 0;
			vertexDistance[startVertex] = 0;
			bfsQueue.offer(startVertex);

			while (!bfsQueue.isEmpty()) {
				int temp = bfsQueue.poll();
				for (int j = 0; j < numberOfVertex + 1; j++) {
					if (graph[temp][j] == 1 && vertexDistance[j] == -1) {
						vertexDistance[j] = vertexDistance[temp] + 1;
						longDistance = vertexDistance[j];
						vertexPredecessor[j] = temp;
						bfsQueue.offer(j);
					}

				} // for

			} // while

			//////////////////////////////////////// result

			ArrayList<Integer> evenArrayList = new ArrayList<Integer>();
			ArrayList<Integer> oddArrayList = new ArrayList<Integer>();
			evenArrayList.add(0);
			oddArrayList.add(0);

			for (int i = 1; i < numberOfVertex + 1; i++) {
				if (vertexDistance[i] % 2 == 1) {
					oddArrayList.add(i);
				} else {
					evenArrayList.add(i);
				}
			}//같은 레이어로 검색을 하면 1층과 3층일때 연결되어 있는 애들도 있음 

			for (int i = 1; i < oddArrayList.size() + 1; i++) {
				for (int j = i + 1; j < oddArrayList.size(); j++) {
					if (graph[oddArrayList.get(i)][oddArrayList.get(j)] == 1) {
						resultdata = 0;
						break;
					}
				}
			}

			for (int i = 1; i < evenArrayList.size() + 1; i++) {
				for (int j = i + 1; j < evenArrayList.size(); j++) {
					if (graph[evenArrayList.get(i)][evenArrayList.get(j)] == 1) {
						resultdata = 0;
						break;
					}
				}
			}
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(resultdata);

		} // tastCase

	}// main

}// class
