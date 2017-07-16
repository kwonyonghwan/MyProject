package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelloWord {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/algorithm/HelloWord.txt"));

		// Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			

			System.out.println((int)sc.nextLine().charAt(0));
		}
	}

}