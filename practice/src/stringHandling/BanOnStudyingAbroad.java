package stringHandling;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BanOnStudyingAbroad {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//StringBuilder builder = new StringBuilder(sc.nextLine());
		StringBuilder builder = new StringBuilder("LOVA");
		Queue<Character> queue = new LinkedList<>();
		
		for(int i=0; i<builder.length(); i++){
			if(!(builder.charAt(i)=='C'||builder.charAt(i)=='A'||builder.charAt(i)=='M'||builder.charAt(i)=='B'||builder.charAt(i)=='R'||builder.charAt(i)=='I'||builder.charAt(i)=='D'||builder.charAt(i)=='G'||builder.charAt(i)=='E')){
				queue.offer(builder.charAt(i));
			}
		}

		while (!queue.isEmpty()) {
			System.out.print(queue.poll());
		}
		
	}// main

}// class
