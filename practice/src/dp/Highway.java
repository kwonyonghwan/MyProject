package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Highway {

	public static void main(String[] args) throws FileNotFoundException {
		//길이 없을때
		//크기가 최소일때 
		// 비용이 초과될때 
		//확인
		/*Input
		1
		2
		2
		1 2 100 1
		1 2 1 100

		Output
		100*/

		Scanner sc = new Scanner(new FileInputStream("src/dp/Highway.txt"));

		int totalFee = sc.nextInt();
		int countOfCity = sc.nextInt() + 1;
		int countOfRoad = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
		
		
		
		int[][] BottomUpMap = new int[totalFee + 1][countOfCity];

		for (int i = 0; i < countOfCity; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i <= totalFee; i++) {
			for (int j = 2; j < countOfCity; j++) {
				BottomUpMap[i][j] = Integer.MAX_VALUE;
			}
		} // forsetting

		for (int i = 0; i < countOfRoad; i++) {
			int startCity = sc.nextInt();
			int endCity = sc.nextInt();
			int lengthOfRoad = sc.nextInt();
			int feeOfRoad = sc.nextInt();

			graph.get(startCity).add(endCity);
			graph.get(startCity).add(lengthOfRoad);
			graph.get(startCity).add(feeOfRoad);
			}

		Queue<CityAndFee> queue = new LinkedList<CityAndFee>();
		CityAndFee startCity = new CityAndFee(1, 0, 0);
		queue.offer(startCity);

		while (!queue.isEmpty()) {

			CityAndFee nowCity = queue.poll();

		
			for (int i = 0; i < graph.get(nowCity.cityNumber).size(); i = i+3) {

				if (nowCity.sumFee + graph.get(nowCity.cityNumber).get(i+2) <= totalFee &&
						nowCity.sumLength + graph.get(nowCity.cityNumber).get(i+1) <
						BottomUpMap[nowCity.sumFee + graph.get(nowCity.cityNumber).get(i+2)][graph.get(nowCity.cityNumber).get(i)]) {
					
					CityAndFee nextCity = new CityAndFee(graph.get(nowCity.cityNumber).get(i),
							nowCity.sumLength + graph.get(nowCity.cityNumber).get(i+1),
							nowCity.sumFee+graph.get(nowCity.cityNumber).get(i+2));
						
					BottomUpMap[nextCity.sumFee][graph.get(nowCity.cityNumber).get(i)] = nowCity.sumLength + graph.get(nowCity.cityNumber).get(i+1);
						
					queue.offer(nextCity);
				
				} // if
				
			}

		} // whileBFs

		int result = Integer.MAX_VALUE;
		for (int i = 0; i < totalFee + 1; i++) {
			result = Math.min(BottomUpMap[i][countOfCity - 1], result);
		}

		if (result< Integer.MAX_VALUE) {
			System.out.println(result);
		} else {
			System.out.println(-1);
		}

	}// main

}// class

class CityAndFee {
	int cityNumber;
	int sumLength;
	int sumFee;

	public CityAndFee(int cityNumber, int sumLength, int sumFee) {
		this.cityNumber = cityNumber;
		this.sumLength = sumLength;
		this.sumFee = sumFee;
	}
}// CityAndFee
