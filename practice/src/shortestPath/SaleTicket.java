package shortestPath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaleTicket {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileInputStream("src/shortestPath/SaleTicket.txt"));

		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfStation = sc.nextInt()+1;
			int numberOfEdge = sc.nextInt();
			int feeOfSaleTicket = sc.nextInt();
			int countOfSaleTicket = 0;
			
			int[][] graph = new int[numberOfStation][numberOfStation];
			
			for(int i=0; i<numberOfStation;i++){
				for(int j=0; j<numberOfStation; j++){
					graph[i][j] = Integer.MAX_VALUE/2;
				}
			}
			
			for(int i=0; i<numberOfEdge; i++){
				int aStation = sc.nextInt();
				int bStation = sc.nextInt();
				graph[aStation][bStation] = graph[bStation][aStation] = sc.nextInt();
			}//forI
		
			for(int k=1; k<numberOfStation; k++){
				for(int i=1; i<numberOfStation; i++){
					for(int j=1; j<numberOfStation; j++){
						graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
					}
				}
			}//floyd
			
			int stage = sc.nextInt();
			for(int i=0; i<stage; i++){
				if(graph[sc.nextInt()][sc.nextInt()] > feeOfSaleTicket){
					countOfSaleTicket++;
				}
			}//forStage
			
			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(countOfSaleTicket); 
			
		}//forTest
	
	}//main
	
}//class