package test;

import java.io.FileNotFoundException;
import java.util.Stack;

public class BaeminTest6 {

	public static void main(String[] args) throws FileNotFoundException {

		String S = "3 DUP 5 - -";
		String[] inputOperation = S.split(" ");
		int result = -1;
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < inputOperation.length; i++) {

			if (inputOperation[i].equals("DUP")) {
				if (stack.size() < 1) {
					stack.clear();
					break;
				}
				stack.push(stack.peek());

			} else if (inputOperation[i].equals("POP")) {
				if (stack.size() < 1) {
					stack.clear();
					break;
				}
				stack.pop();

			} else if (inputOperation[i].equals("+")) {
				if (stack.size() < 2) {
					stack.clear();
					break;
				}
				stack.push(stack.pop() + stack.pop());

			} else if (inputOperation[i].equals("-")) {
				if (stack.size() < 2) {
					stack.clear();
					break;
				}
				int temp = stack.pop() - stack.pop();
				if (temp < 0) {
					stack.clear();
					break;
				}
				stack.push(temp);

			} else {
				stack.push(Integer.parseInt(inputOperation[i]));
			}
		}

		if (!stack.isEmpty()) {
			result = stack.pop();
		}

		System.out.println(result);
		// return result;
	}// main

}// class
