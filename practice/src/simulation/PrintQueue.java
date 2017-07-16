package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

public class PrintQueue {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/simulation/PrintQueue.txt"));

		// Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int countOfDocument = sc.nextInt();
			int targetPoition = sc.nextInt();

			Queue<printObject> printQueue = new LinkedList<printObject>();

			for (int i = 0; i < countOfDocument; i++) {
				Boolean target = false;
				if (i == targetPoition) {
					target = true;
				}
				printObject object = new printObject(sc.nextInt(), target);
				printQueue.offer(object);
			} // for Setting

			int count = 0;
			while (!printQueue.isEmpty()) {
				printObject nowObject = printQueue.poll();

				java.util.Iterator<printObject> itr = printQueue.iterator();
				boolean biggest = true;
				
				while (itr.hasNext()) {
					printObject temp = itr.next();

					if (nowObject.importance < temp.importance) {
						printQueue.offer(nowObject);
						biggest = false;
						break;
					}
				} // searchBigger

				if (biggest) {
					count++;
					if (nowObject.target) {
						System.out.println(count);
						break;
					}
				}//ifBiggest

			}

		} // testCase
	}// main

}// class

class printObject {
	int importance;
	Boolean target;

	public printObject(int i, boolean target) {
		this.importance = i;
		this.target = target;
	}

}
