package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SaleTicket2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/SaleTicket.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfStation = sc.nextInt() + 1;
			int numberOfEdge = sc.nextInt();
			int feeOfSaleTicket = sc.nextInt();
			int countOfSaleTicket = 0;
			int feeOfStep = 0;

			int[][] graph = new int[numberOfStation][numberOfStation];

			for (int i = 0; i < numberOfStation; i++) {
				for (int j = 0; j < numberOfStation; j++) {
					graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}

			for (int i = 0; i < numberOfEdge; i++) {
				int aStation = sc.nextInt();
				int bStation = sc.nextInt();
				graph[aStation][bStation] = graph[bStation][aStation] = sc.nextInt();
			} // forI

			int step = sc.nextInt();

			for (int i = 0; i < step; i++) {

				if (feeOfSaleTicket < dijkstra(graph, sc.nextInt(), sc.nextInt())) {
					countOfSaleTicket++;
				}
			}

			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println("Case #" + test_case);
			System.out.println(countOfSaleTicket);

		} // forTest

	}// main

	public static int dijkstra(int[][] graph, int startStation, int endStation) {

		int[] distance = new int[graph.length]; //���������� �� ���������� �Ÿ�
		boolean[] endSet = new boolean[graph.length];
		// �ּڰ��� ã������  ���⿡ �߰��Ѵ�. -> ���� ���� ������ �� ���� (���⿡ ���� ���� index��  distance[]���� ������ �������� �� �������� �ִܰŸ�

		for(int i=0; i<endSet.length; i++){
			endSet[i] = false;
		}//�ʱ�ȭ
		for (int i = 0; i < graph[0].length; i++) {
			distance[i] = Integer.MAX_VALUE / 2;
		}// �ּڰ� ����� MIN �������� �ϴϱ� ������ ���Ѵ� ���� �����ϴµ� double ������ �����ؼ�  INT�� MAX������ ����

		distance[startStation] = 0; //���� ��
		
		for (int i = 0; i < graph.length - 1; i++) {

			int min = Integer.MAX_VALUE / 2;
			int index = -1 ;

			for (int j = 0; j < distance.length; j++) {
				if (!endSet[j] && min > distance[j]) {
					min = distance[j];
					index = j;
				}
			} // forMinSearch   �� ���ܸ���  endset���� �湮���� ���� ������ �ӿ��� distance���� �ּ��ΰ��� ã��

			endSet[index] = true; // �� �������� �Ļ��Ǵ� �ִܰŸ��� ���Ҳ��ϱ� �湮�ߴٰ� ����

			for (int j = 1; j < distance.length; j++) {
				if (distance[j] > distance[index] + graph[index][j] ) {
					distance[j] = distance[index] + graph[index][j];
				}
			} // forRelaxtion �ִ� �Ÿ��� ���ؼ� ������Ʈ 

		}//forSearchShortestPath  �̰� ������ distance[]�迭���� ���� �� ���� �� ����������� �ִܰŸ��� ����Ǿ� �ִ�.

		
		return distance[endStation]; 
	}// dijkstra

}// class
