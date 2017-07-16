package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountGroupWord {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/CountGroupWord.txt"));

		// Scanner sc = new Scanner(System.in);
		System.out.println();
		int TC = sc.nextInt();
		int count = 0;
		sc.nextLine();

		for (int testCase = 1; testCase <= TC; testCase++) {

			String inputWord = sc.nextLine();
			boolean[] checkGroupWord = new boolean[91];
			boolean flag = false;
			checkGroupWord[(int) inputWord.toUpperCase().charAt(0)] = true;
			for (int i = 1; i < inputWord.length(); i++) {
				if (checkGroupWord[(int) inputWord.toUpperCase().charAt(i)]
						&& inputWord.charAt(i - 1) != inputWord.charAt(i)) {
					flag = true;
					break;
				}
				checkGroupWord[(int) inputWord.toUpperCase().charAt(i)] = true;
			}
			if (!flag) {
				count++;
			}
		} // for
		System.out.println(count);

	}

}
