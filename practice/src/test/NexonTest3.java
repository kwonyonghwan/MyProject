package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class NexonTest3 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);

		String s = "000";
		int result = 0;
		
		if(!s.contains("1")){
			System.out.println("-1");
		}

		String[] powerOf5List = { "1", "101", "11001", "1111101", "1001110001", "110000110101", "11110100001001",
				"10011000100101101", "1011111010111100001", "111011100110101100101", "100101010000001011111001",
				"10111010010000111011011101", "1110100011010100101001010001" };
		for (int index = 12; index > -1; index--) {

			Stack<Character> stack = new Stack<Character>();
			String explosion = powerOf5List[1];

			for (int i = s.length() - 1; i > -1; i--) {
				stack.push(s.charAt(i));
				if (powerOf5List[index].length() < explosion.length()) {

					if (stack.size() >= explosion.length() && stack.peek() == explosion.charAt(0)) {
						boolean isExplosion = true;

						for (int j = 1; j < explosion.length(); j++) {
							if (stack.get(stack.size() - j - 1) != explosion.charAt(j)) {
								isExplosion = false;
								break;
							}
						}

						if (isExplosion) {
							result++;
							for (int j = 0; j < explosion.length(); j++) {
								stack.pop();
							}
						}
					}
				}

			} // forKMPSearch

			StringBuffer buffer = new StringBuffer();
			if (stack.size() > 0) {
			} else {
				break;
			}

		}

		System.out.println(result);
	}// main

}// class
