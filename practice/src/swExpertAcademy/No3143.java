package swExpertAcademy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class No3143 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/swExpertAcademy/No3143.txt"));

		// Scanner sc = new Scanner(System.in);

		int test_Case;
		int T = sc.nextInt();
		sc.nextLine();

		for (test_Case = 1; test_Case <= T; test_Case++) {

			int result = 0;

			String stringA = sc.next();
			String stringB = sc.next();

			Stack<Character> stack = new Stack<>();

			for (int i = 0; i < stringA.length(); i++) {

				stack.push(stringA.charAt(i));
				if (stack.size() >= stringB.length() && stack.peek() == stringB.charAt(stringB.length() - 1)) {

					boolean isFindStringB = true;
					// check
					for (int j = 0; j < stringB.length(); j++) {
						if (stack.get(stack.size() - 1 - j) != stringB.charAt(stringB.length() - 1 - j)) {
							isFindStringB = false;
							break;
						}
					} // forFindStringB

					// pop&&++

					if (isFindStringB) {
						for (int j = 0; j < stringB.length(); j++) {
							stack.pop();
						}
						result++;
					}//ifIsFindStringB

				}//ifFindLastCharector

			}

			while (!stack.isEmpty()) {
				stack.pop();
				result++;
			}

			System.out.println("#" + test_Case + " " + result);

		} // forTestCase

	}// main

}// class