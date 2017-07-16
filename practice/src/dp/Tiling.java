package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Tiling {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/Tiling.txt"));

		// Scanner sc = new Scanner(System.in);

		BigInteger[] countOfSolution = new BigInteger[251];
		countOfSolution[0] = new BigInteger("0");
		countOfSolution[1] = new BigInteger("1");
		countOfSolution[2] = new BigInteger("3");

		for (int i = 3; i < 251; i++) {
			countOfSolution[i] = new BigInteger("0");
			countOfSolution[i] = countOfSolution[i].add(countOfSolution[i - 1]);
			countOfSolution[i] = countOfSolution[i].add((countOfSolution[i - 2]).multiply(BigInteger.valueOf(2)));
		}

		while (sc.hasNext()) {
			// 이 부분에서 정답을 출력하십시오.
			System.out.println(countOfSolution[sc.nextInt()]);
		} // forTest

	}// main

}// class
