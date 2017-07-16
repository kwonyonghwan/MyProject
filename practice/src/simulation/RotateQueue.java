package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RotateQueue {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/simulation/RotateQueue.txt"));

		// Scanner sc = new Scanner(System.in);
		int sizeOfQueue = sc.nextInt();
		int sizeOfTarget = sc.nextInt();
		int result = 0;

		ArrayList<Integer> orderList = new ArrayList<Integer>();
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		for (int i = 0; i < sizeOfTarget; i++) {
			orderList.add(sc.nextInt());
		}

		for (int i = 1; i <= sizeOfQueue; i++) {
			arrayList.add(i);
		}

		while (orderList.size() > 0) {
			
			if (orderList.get(0) == arrayList.get(0)) {
				orderList.remove(0);
				arrayList.remove(0);
				continue;
			} // Action1

			int index = arrayList.indexOf(orderList.get(0));

			if (index < ((arrayList.size() / 2) + 1)) {
				for (int i = 0; i < index; i++) {
					arrayList.add(arrayList.get(0));
					arrayList.remove(0);
					result++;
				}
				arrayList.remove(0);
				orderList.remove(0);
			} /* Action2 */else {
				index = arrayList.size() - index;
				ArrayList<Integer> tempArray = new ArrayList<Integer>();

				for (int i = 0; i < index; i++) {
					tempArray.add(0,arrayList.get(arrayList.size() - 1));
					arrayList.remove(arrayList.size() - 1);
					result++;
				}
				arrayList.addAll(0, tempArray);
				arrayList.remove(0);
				orderList.remove(0);
			}

		}

		System.out.println(result);

	}// main

}// class
