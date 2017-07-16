package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Retire {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Retire.txt"));
	//	Scanner sc = new Scanner(System.in);
		
		int T;
		int test_case;
		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfDay = sc.nextInt() + 1;
			int[][] priceMap = new int[numberOfDay][numberOfDay];
			int[][] clientList = new int[numberOfDay][2];

			for (int i = 1; i < clientList.length; i++) {
				clientList[i][0] = sc.nextInt();
				clientList[i][1] = sc.nextInt();
			}

			for (int i = 1; i < priceMap.length; i++) {
				for (int j = 1; j < priceMap[0].length; j++) {
					if (j == (i + clientList[i][0] - 1)) {
						priceMap[i][j] = Math.max(priceMap[i - 1][i + clientList[i][0] - 1],
								priceMap[i - 1][i - 1] + clientList[i][1]);
						continue;
					}
					priceMap[i][j] = Math.max(priceMap[i][j - 1], priceMap[i - 1][j]);
				}
			} // forBottomUp

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case + " " + priceMap[priceMap.length - 1][priceMap[0].length - 1]);

		} // forTest

	}// mains

}// class
