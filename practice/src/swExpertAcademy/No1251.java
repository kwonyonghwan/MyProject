package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class No1251 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No1251.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;
		int T = sc.nextInt();

		for (test_Case = 1; test_Case <= T; test_Case++) {
			long result = 0;

			int countOfIsland = sc.nextInt();
			long[][] graph = new long[countOfIsland][countOfIsland];
			long[][] positionIsland = new long[countOfIsland][2];
			for (int i = 0; i < countOfIsland; i++) {
				positionIsland[i][0] = sc.nextInt();
			} // forSetting
			for (int i = 0; i < countOfIsland; i++) {
				positionIsland[i][1] = sc.nextInt();
			} // forSetting

			for (int i = 0; i < countOfIsland; i++) {
				for (int j = 0; j < countOfIsland; j++) {
					graph[i][j] = (positionIsland[i][0] - positionIsland[j][0])
							* (positionIsland[i][0] - positionIsland[j][0])
			 				+ (positionIsland[i][1] - positionIsland[j][1])
									* (positionIsland[i][1] - positionIsland[j][1]);
				}
			} // forCalcdistance

			boolean[][] visitiedMap = new boolean[countOfIsland][countOfIsland];
			
			
			
			
			
			
			
			
			double temp = (result * sc.nextDouble());

			System.out.println(temp);
			// System.out.println("#" + test_Case + " " + (result *
			// sc.nextDouble()));

		} // forTestCase

	}// main

}// class