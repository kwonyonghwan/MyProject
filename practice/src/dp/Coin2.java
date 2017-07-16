package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Coin2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Coin2.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfN = sc.nextInt();
			int numberOfK = sc.nextInt() + 1;

			int[] coinList = new int[101];
			int[] moneyList = new int[10001];

			for (int i = 1; i < numberOfK; i++) {
				moneyList[i] = Integer.MAX_VALUE;
			}
			for (int i = 0; i < numberOfN; i++) {
				coinList[i] = sc.nextInt();
			}//forSetting

			for (int i = 1; i < moneyList.length; i++) {
				for (int j = 0; j < coinList.length; j++) {
					if (i - coinList[j] >= 0) {
						moneyList[i] = Math.min(moneyList[i - coinList[j]], moneyList[i]);
					}
				}

				if (moneyList[i] == Integer.MAX_VALUE) {
					continue;
				}
				moneyList[i]++;
			} // forMoneyList

			if (moneyList[numberOfK - 1] == Integer.MAX_VALUE) {
				System.out.println(-1);
			} else {
				System.out.println("Case #" + test_case + " " + moneyList[numberOfK - 1]);
			}
		} // forTest

	}// main

}// class
