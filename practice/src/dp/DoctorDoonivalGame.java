package dp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DoctorDoonivalGame {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("src/dp/DoctorDoonivalGame.txt"));

		int T;
		int test_case;

		T = sc.nextInt();
		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfTown = sc.nextInt();
			int day = sc.nextInt();
			int prisonInTown = sc.nextInt();

			boolean[][] graph = new boolean[numberOfTown][numberOfTown];
			double[] probabilityOfTown = new double[numberOfTown];
			double[] stepResultList = new double[numberOfTown];
			double[] resultList = new double[numberOfTown];
			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < numberOfTown; i++) {
				int count = 0;
				for (int j = 0; j < numberOfTown; j++) {
					if (sc.nextInt() == 1) {
						count++;
						graph[i][j] = true;
					}
				}
				probabilityOfTown[i] = (double) 1 / count;
			} // forI

			for(int i=0; i<numberOfTown; i++){
				resultList[i] = 1;
			}
			
			int resultNumber = sc.nextInt();
			int[] resultTownLsit = new int[resultNumber];

			for (int i = 0; i < resultNumber; i++) {
				resultTownLsit[i] = sc.nextInt();
			} // forI
			
			queue.offer(prisonInTown);
			queue.offer(-1);
			int tempOfTown;
			
			for (int i = 0; i < day; i++) {
				tempOfTown = queue.poll();
				while (tempOfTown > -1) {
					for (int j = 0; j < numberOfTown; j++) {
						if(graph[tempOfTown][j]){
							stepResultList[j] += probabilityOfTown[tempOfTown]*resultList[tempOfTown];
							queue.offer(j);
						}	
					}//forJ
					tempOfTown = queue.poll();
				} // whileStep
				queue.offer(-1);
				  
				resultList = Arrays.copyOf (stepResultList, stepResultList.length);
				for(int k=0; k<numberOfTown; k++){
					stepResultList[k]=0;
				}
			} // forDay

			
			for(int i=0; i<resultNumber; i++){
				System.out.print(resultList[resultTownLsit[i]]+" ");
			}
			
			System.out.println(" ");
		
		} // forT
	}// main
}// class
