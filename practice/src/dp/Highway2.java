/*package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Highway2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Highway.txt"));

		int totalFee = sc.nextInt();
		int countOfCity = sc.nextInt() + 1;
		int countOfRoad = sc.nextInt();
		int[][][] graph = new int[countOfCity][countOfCity][2];
		int[][] BottomUpMap = new int[totalFee + 1][countOfCity];

		for (int i = 0; i < countOfCity; i++) {
			for (int j = 0; j < countOfCity; j++) {
				graph[i][j][0] = -1;
			}
		}
		for (int i = 0; i <= totalFee; i++) {
			for (int j = 2; j < countOfCity; j++) {
				BottomUpMap[i][j] = Integer.MAX_VALUE;
			}
		} // forsetting

		for (int i = 0; i < countOfCity; i++) {
			int startCity = sc.nextInt();
			int endCity = sc.nextInt();
			int lengthOfRoad = sc.nextInt();
			int feeOfRoad = sc.nextInt();

			graph[startCity][endCity][0] = lengthOfRoad;
			graph[startCity][endCity][1] = feeOfRoad;
		}

		Queue<CityAndFee> queue = new LinkedList<CityAndFee>();
		CityAndFee startCity = new CityAndFee(1, 0);
		queue.offer(startCity);

		while (!queue.isEmpty()) {

			CityAndFee nowCity = queue.poll();

			for (int i = 0; i < countOfCity; i++) {

				if (graph[nowCity.cityNumber][i][0] > -1 && nowCity.sumFee + graph[nowCity.cityNumber][i][1] <= totalFee
						&& BottomUpMap[nowCity.sumFee][nowCity.cityNumber] + graph[nowCity.cityNumber][i][0] <
							 BottomUpMap[nowCity.sumFee	+ graph[nowCity.cityNumber][i][1]][i]) {

					CityAndFee nextCity = new CityAndFee(i, nowCity.sumFee + graph[nowCity.cityNumber][i][1]);
					BottomUpMap[nextCity.sumFee][i] = BottomUpMap[nowCity.sumFee][nowCity.cityNumber]
							+ graph[nowCity.cityNumber][i][0];

					queue.offer(nextCity);

				} // if

			}

		} // whileBFs

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < totalFee + 1; i++) {
			result = Math.min(BottomUpMap[i][countOfCity - 1], result);
		}

		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

	}// main

}// class

class CityAndFee {
	int cityNumber;
	int sumFee;

	public CityAndFee(int cityNumber, int sumFee) {
		this.cityNumber = cityNumber;
		this.sumFee = sumFee;
	}
}// CityAndFee
*/