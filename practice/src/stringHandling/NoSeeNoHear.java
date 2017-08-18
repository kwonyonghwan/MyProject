package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class NoSeeNoHear {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/NoSeeNoHear.txt"));

		// Scanner sc = new Scanner(System.in);

		int noSeeCount = sc.nextInt();
		int noHearCount = sc.nextInt();
		sc.nextLine();

		TreeSet<String> noSeeSet = new TreeSet<>();
		TreeSet<String> noHearSet = new TreeSet<>();

		for (int i = 0; i < (noHearCount + noSeeCount); i++) {
			if (i < noHearCount) {
				noSeeSet.add(sc.nextLine());
			} else {
				noHearSet.add(sc.nextLine());
			}
		}

		noSeeSet.retainAll(noHearSet);

		System.out.println(noSeeSet.size());
		for (String string : noSeeSet) {
			System.out.println(string);
		}
		
	}// main

}// class
