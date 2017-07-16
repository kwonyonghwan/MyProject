package dfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.IntPredicate;

public class MakePassword {

	static int[][] graph;
	static Stack<Integer> stack;
	static boolean[] visitVertex;
	static int L ;
	static int C ;
	
	
	
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/dfs/makePassword_input_sample.txt"));

		L = sc.nextInt();
		C = sc.nextInt();
		graph= new int[C][C];
		visitVertex = new boolean[C];
		stack = new Stack<Integer>();
		char[] inputData = new char[C];

		for (int i = 0; i < C; i++) {
			inputData[i] = sc.next().charAt(0);
		}

		Arrays.sort(inputData);

		for (char d : inputData) {
			System.out.println(d);
		}

		for (int i = 0; i < C; i++) {
			for (int j = i + 1; j < C; j++) {
				graph[i][j] = 1;
			}
		}
		DFS(0);

		//DFSALL(inputData);

	}// main

	private static void DFS(int startVertex) {
		int tempvertax = startVertex;
		System.out.println("tempvertax :"+ tempvertax +"stack :" + stack.toString());
		PrintGraph();
		
		if(stack.size()>3){
			System.out.println(stack.toString());
			stack.pop();
			DFS(tempvertax);
		}
		
	
		for(int i=1; i<C; i++){
			if(graph[tempvertax][i] == 1 ){
			
				System.out.println(tempvertax+" ---> " + i);
				stack.push(tempvertax);
				graph[tempvertax][i] = 0;
				int temp = stack.pop();
				stack.push(temp);
				DFS(temp);
			}
		}//for
		
		for(int i=tempvertax+1; i<6; i++){
			graph[tempvertax][i] = 1;
		}
		
	}//DFS
	
	public static void PrintGraph()
	{
		for(int i=0; i<C; i++){
		for(int j=0; j<C; j++){
			System.out.print(graph[i][j]);
		}
		System.out.println();
	}//graph
		
	}
}// class
