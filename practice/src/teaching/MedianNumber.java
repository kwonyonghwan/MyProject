package teaching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MedianNumber {

	public static void main(String[] args) throws FileNotFoundException {

//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("src/teaching/MedianNumber.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		sc.nextLine();

		for (test_case = 1; test_case <= T; test_case++) {
			// �� �κп��� �˰����� �����Ͻʽÿ�.
			
			int N = sc.nextInt();
			
			int[][] graph = new int[N][N];
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					graph[i][j] = sc.nextInt();
				}
			}//forSetting
		
			int[][] A = new int[N][N];
			
			//1���� 
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					A[i][j] = graph[i][j];
				}
			}//forSetting
			
			//2����
			
			for(int i=0; i<N; i++ ){
				 Arrays.sort(graph[i]);
			}
			
			for(int i=0; i<N; i++){
				int[] temp = new int[N];
				for(int j=0; j<N; j++){
					temp[j] = A[j][i];
				}
				Arrays.sort(temp);
				for(int j=0; j<N; j++){
					A[j][i] = temp[j];
				}
			}
			
			
			//3üũ��� 
			int result = 0;
			int[] checkArray = new int[N*N+1];
			
			for(int i=0; i<N; i++){
				int index =A[N/2][i]; 
				checkArray[index]++;
			}
			
			for(int i=0; i<N; i++){
				int index =graph[i][N/2]; 
				if(checkArray[index]>0){
					result++;
				}
				
			}
			
			
			
			// �� �κп��� ������ ����Ͻʽÿ�.
			System.out.println(result);
		}//forTest

	}//main

}//class
