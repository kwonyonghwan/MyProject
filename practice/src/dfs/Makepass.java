package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.IntPredicate;

public class Makepass {

	static int[][] graph;
	static Stack<Integer> stack;
	static boolean[] visitVertex;
	static int stackSize;
	static int consonant;// 자음
	static int vowel;// 모음 a, e, i, o, u (0, 4, 8, 14, 20)
	static int L ;
	static int C ;
	
	
	
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/makePassword_input_sample.txt"));

		L = sc.nextInt();
		C = sc.nextInt();
		System.out.println(L + " " + C);
		char[] inputData = new char[C];
		graph = new int[26][26];
		stack = new Stack<Integer>();
		visitVertex = new boolean[26];
		// 모음 0, 4, 8, 14, 20
		consonant = 0;
		vowel = 0;
		stackSize =1;

		for (int i = 0; i < C; i++) {
			inputData[i] = sc.next().charAt(0);
		}

		Arrays.sort(inputData);

		for (char d : inputData) {
			System.out.println(d);
		}

		for (int i = 0; i < C; i++) {
			for (int j = i + 1; j < C; j++) {
				graph[(int) inputData[i] - 97][(int) inputData[j] - 97] = 1;
			}
		}

		// DFS(0);

		DFSALL(inputData);

	}// main

	private static void DFSALL(char[] inputData) {
		for (int i = 0; i < C; i++) {
			for(int j=0; j<C; j++){
				DFS((int) inputData[i] - 97, (int)inputData[j] - 97);
			}
		}
	}// DFSALL

	private static void DFS(int x, int y) {
		
		graph[x][y] = 0;
		
		for(int i=1; i<visitVertex.length; i++){
			if(graph[x][i] == 1 && !visitVertex[i]){
				DFS(x,y);
			}
		}
		
		graph[x][y]	= 1;
		
	}//DFS
}// class
