package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

class City implements Comparable<City> {
	int cityNumber;
	Long cityFee;

	public City(int cityNumber, Long distanceMap) {
		this.cityNumber = cityNumber;
		this.cityFee = distanceMap;
	}

	@Override
	public int compareTo(City target) {
		if (this.cityFee > target.cityFee) {
			return 1;
		} else if (this.cityFee < target.cityFee) {
			return -1;
		}
		return 0;
	}
}

public class MinimumFee {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/MinimumFee.txt"));

		int countOfCity = sc.nextInt() + 1;
		int countOfBus = sc.nextInt();

		int[][] graph = new int[countOfCity][countOfCity];
		Long[] distanceMap = new Long[countOfCity];
		boolean[] endSet = new boolean[countOfCity];
		
		for (int i = 0; i < countOfCity; i++) {
			for (int j = 0; j < countOfCity; j++) {
				if(i==j){
					graph[i][j] = 0;
				}else{
				graph[i][j] = Integer.MAX_VALUE / 2;
				}
			}
		}

		for (int i = 0; i < countOfBus; i++) {
			int positionI = sc.nextInt();
			int positionJ = sc.nextInt();
			graph[positionI][positionJ] = Math.min(graph[positionI][positionJ], sc.nextInt());
		} // forSetting

		int startCity = sc.nextInt();
		int endCity = sc.nextInt();

		for (int i = 0; i < countOfCity; i++) {
			distanceMap[i] = (long) (Integer.MAX_VALUE / 2);
		} // forSetting

		City startCity1 = new City(startCity, (long) 0);
		PriorityQueue<City> priorityQueue = new PriorityQueue<City>();
		distanceMap[startCity] = (long) 0;
		priorityQueue.offer(startCity1);

		while(!priorityQueue.isEmpty()) {

			City nowCity = priorityQueue.poll();
			endSet[nowCity.cityNumber] = true;

			for (int j = 1; j < countOfCity; j++) {
				if (!endSet[j]) {
					if (distanceMap[j] > distanceMap[nowCity.cityNumber] + graph[nowCity.cityNumber][j]) {
						distanceMap[j] = distanceMap[nowCity.cityNumber] + graph[nowCity.cityNumber][j];
						City nextCity = new City(j, distanceMap[j]);
						priorityQueue.offer(nextCity);
					}
				}

			}

		}

		System.out.println(distanceMap[endCity]);

	}// main

}// class
