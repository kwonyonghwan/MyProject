package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

class Bottle {
	int[] bottleSize = new int[3];

	public Bottle(int sizeOfA, int sizeOfB, int sizeOfC) {
		this.bottleSize[0] = sizeOfA;
		this.bottleSize[1] = sizeOfB;
		this.bottleSize[2] = sizeOfC;
	}
}

public class WaterBottle {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/WarterBottle.txt"));

		// Scanner sc = new Scanner(System.in);
		int[] bottleSizeList = { sc.nextInt(), sc.nextInt(), sc.nextInt() };
		boolean[][][] visitiedMap = new boolean[201][201][201];

		Queue<Bottle> bottleQueue = new LinkedList<>();
		Bottle startBottle = new Bottle(0, 0, bottleSizeList[2]);
		visitiedMap[startBottle.bottleSize[0]][startBottle.bottleSize[1]][startBottle.bottleSize[2]] = true;
		bottleQueue.offer(startBottle);

		TreeSet<Integer> resultList = new TreeSet<>();

		while (!bottleQueue.isEmpty()) {
			Bottle nowBottle = bottleQueue.poll();

			if (nowBottle.bottleSize[0] == 0) {
				resultList.add(nowBottle.bottleSize[2]);
			}
			// 가능한 애들 들가기 +1 +2

			for (int i = 0; i < 3; i++) {
				for (int j = 1; j < 3; j++) {

					Bottle nextBottle = new Bottle(nowBottle.bottleSize[0], nowBottle.bottleSize[1],
							nowBottle.bottleSize[2]);
					if (nowBottle.bottleSize[i] < (bottleSizeList[(i + j) % 3] - nowBottle.bottleSize[(i + j) % 3])) {
						nextBottle.bottleSize[(i + j) % 3] += nowBottle.bottleSize[i];
						nextBottle.bottleSize[i] = 0;
					} else {
						int temp = bottleSizeList[(i + j) % 3] - nowBottle.bottleSize[(i + j) % 3];
						nextBottle.bottleSize[(i + j) % 3] += temp;
						nextBottle.bottleSize[i] -= temp;
					}

					if (!visitiedMap[nextBottle.bottleSize[0]][nextBottle.bottleSize[1]][nextBottle.bottleSize[2]]) {
						visitiedMap[nextBottle.bottleSize[0]][nextBottle.bottleSize[1]][nextBottle.bottleSize[2]] = true;
						bottleQueue.offer(nextBottle);
					}

				}// forNextBottle
			}//forCase 

		}//whileBFS

		for (Integer integer : resultList) {
			System.out.print(integer+" ");
		}

	}// main

}// class