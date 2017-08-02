package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BipartiteGraph2 {

	static String isTwoGraph = "YES";

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/bfs/BipartiteGraph.txt"));
		//Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int i = 0; i < TC; i++) {

			isTwoGraph = "YES";
			int v = sc.nextInt();
			int e = sc.nextInt();
			// 배열을 동적으로 만들기
			List<Integer> col = new ArrayList<>();
			List<List<Integer>> row = new ArrayList<>();

			for (int j = 0; j < v + 1; j++) {
				row.add(new ArrayList<>());
			}

			boolean[] visit = new boolean[v + 1];
			int[] red = new int[v + 1];
			int[] blue = new int[v + 1];

			int go = 0;
			for (int j = 0; j < e; j++) {

				int start = sc.nextInt();
				int end = sc.nextInt();

				if (j == 0) {
					go = start;
				}

				row.get(start).add(end);
				row.get(end).add(start);

			}
			boolean flag = false;
			// true면 빨강 false면 파랑a
			visit[go] = true;
			dfs(go, red, blue, flag, visit, row);
			System.out.println(isTwoGraph);

		}

	}

	private static void dfs(int vertex, int[] red, int[] blue, boolean flag, boolean[] visit, List<List<Integer>> row) {

		flag = !flag;

		if (flag) {
			red[vertex] = 1;
		} else {
			blue[vertex] = 1;

		}

		while (!row.get(vertex).isEmpty()) {
			// 정점이 연결되어있고 집합에 아직 포함되어있지 않았다면 dfs 이동
			int num = row.get(vertex).get(0);
			row.get(vertex).remove(0);

			// System.out.println(num);
			if (flag && red[num] == 1) {
				isTwoGraph = "NO";
			} else if (!flag && blue[num] == 1) {
				isTwoGraph = "NO";
			}
			if (!visit[num] ) {
				visit[num] = true;
				dfs(num, red, blue, flag, visit, row);
			}

		}

	}
}