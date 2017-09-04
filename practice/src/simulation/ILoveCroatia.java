package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ILoveCroatia {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/simulation/ILoveCroatia.txt"));
		// Scanner sc = new Scanner(System.in);

		int bombPosition = sc.nextInt()-1;
		int countOfQuestion = sc.nextInt();
		int timeOfGame = 0;

		for (int i = 0; i < countOfQuestion; i++) {

			timeOfGame += sc.nextInt();

			if (timeOfGame >= 210) {
				break;
			}

			if (sc.next().equals("T")) {
				bombPosition = (bombPosition + 1)% 8;
			}

		} // whileGame

		System.out.println(bombPosition++);

	}// main

}// class