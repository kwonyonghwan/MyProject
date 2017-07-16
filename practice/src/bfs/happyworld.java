package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/* ����ϴ� Ŭ�������� Solution �̾�� �ϸ�, ������ Solution.java �� ����� ���� �����մϴ�.
   �̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� ������ �� �� �ֽ��ϴ�. */

public class happyworld {

	public static void main(String[] args) throws FileNotFoundException {

		/*
		 * �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� sample_input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		 * ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� sample_input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		 * ǥ���Է� ��� sample_input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�. ����, ���� PC���� �Ʒ� �޼ҵ带
		 * ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�. ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ��
		 * �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�.
		 */
		Scanner sc = new Scanner(new FileInputStream("src/bfs/input_sample.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰��� ���α׷��� �ۼ��Ͻʽÿ�. �⺻ ������ �ڵ带 ���� �Ǵ� �����ϰ� ������ �ڵ带 ����ϼŵ�
			// �˴ϴ�.

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
			}//���� ���̾�� �˻��� �ϸ� 1���� 3���϶� ����Ǿ� �ִ� �ֵ鵵 ���� 

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
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(resultdata);

		} // tastCase

	}// main

}// class
