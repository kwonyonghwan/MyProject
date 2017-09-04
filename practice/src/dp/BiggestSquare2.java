package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import algorithm.PrintGraph;

public class BiggestSquare2 {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dp/BiggestSquare.txt"));
		// Scanner sc = new Scanner(System.in);

		int sizeOfN = sc.nextInt() + 1;
		int sizeOfM = sc.nextInt() + 1;
		sc.nextLine();
		int[][] graph = new int[sizeOfN][sizeOfM];
		int maxValue = 0;

		for (int i = 1; i < sizeOfN ; i++) {
			String temp = sc.nextLine();
			for (int j = 1; j < sizeOfM; j++) {
				graph[i][j] = Character.getNumericValue(temp.charAt(j - 1));
				maxValue = Math.max(maxValue, graph[i][j]);
			}
		}
 
		for(int i=1; i<sizeOfN; i++){
			for(int j=1; j<sizeOfM; j++){
				if(graph[i][j]>0 && graph[i-1][j]>0 && graph[i][j-1]>0){
					graph[i][j] = Math.min(graph[i-1][j], graph[i][j-1]);
					if(graph[i-graph[i][j]][j-graph[i][j]]>0){
						graph[i][j]++;
					}
					maxValue = Math.max(maxValue, graph[i][j]);
				}
			}
		}//forMakeBottomUpMap
			
		System.out.println(maxValue*maxValue);
	}// main

}// class
