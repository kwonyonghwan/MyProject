package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MidasTest5 {

	public static void main(String[] args) throws FileNotFoundException {
		
//		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest5.txt"));

		 Scanner sc = new Scanner(System.in);

		int N = sc.nextInt()+1;
		int M = sc.nextInt();
		int result = 0;
		
		int[][] graph = new int[N][N];
		boolean[][] visitiedMap = new boolean[N][N];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				graph[i][j]=10001;
			}
		}
		
		for(int i=0; i<M; i++){
			int tempA = sc.nextInt();
			int tempB = sc.nextInt();
			graph[tempA][tempB]= graph[tempB][tempA]= sc.nextInt();
		}
		
		
		for(int i=1; i<N-1; i++){
			int minIndexI = 0;
			int minIndexJ = 0;
			int minValue = 10001;
			
			for(int j=0; j<N; j++){
				for(int k=0; k<N; k++){
					if(!visitiedMap[j][k] && minValue > graph[j][k]){
						 minIndexI = j;
						 minIndexJ = k;
						 minValue = graph[j][k];
					}
				}
			}
			
			result+=minValue;
			
			for(int j=0; j<N; j++){
				visitiedMap[minIndexI][j] = true;
			}
			visitiedMap[minIndexJ][minIndexI] = true;
			
			if(minIndexI==0){
				result=-1;
				break;
			}
			
		}
		
		System.out.println(result);
		

	}// main

}// class
