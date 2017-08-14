package bfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrimeNumberRoad {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/bfs/PrimeNumberRoad.txt"));

		// Scanner sc = new Scanner(System.in);
		
		boolean[] PrimeNumber = new boolean[10001];
		
		for(int i=1000; i<10001; i++){
			boolean primeNumber = true;
			
			for(int j=2; j<i; j++){
				if(i%j==0){
					primeNumber = false;
					break;
				}
			}//forCheckPrime
			
			if(primeNumber){
				PrimeNumber[i]=true;
			}
		}//makePrimeNumberList
		
		int T;
		int test_case;

		T = sc.nextInt();

		for (test_case = 1; test_case <= T; test_case++) {

			int numberOfA = sc.nextInt();
			int numberOfB = sc.nextInt();
			boolean[] visitiedMap = new boolean[10001];
			if(numberOfA==numberOfB){
				System.out.println(0);
				continue;
			}
			
			Queue<Integer> queue = new LinkedList<Integer>();
			visitiedMap[numberOfA]=true;
			queue.add(numberOfA);
			int step = -1;
			
			while(!queue.isEmpty()){
				int queueSize = queue.size();
				step++;
				
				for(int i=0; i<queueSize; i++){
					
					int nowNumber = queue.poll();
					String tempNumber = String.valueOf(nowNumber);
					for(int j=0; j<4; j++){
						
						char[] tempCharArray = tempNumber.toCharArray();
						for(int k=48; k<58; k++){
							
							tempCharArray[j] = (char)k;
							
							String nextStepNumber = ""+tempCharArray[0]+tempCharArray[1]+tempCharArray[2]+tempCharArray[3];
							int nextNumber = Integer.parseInt(nextStepNumber);
							
							if(nextNumber>999&&PrimeNumber[nextNumber]&&!visitiedMap[nextNumber]){
								visitiedMap[nextNumber]=true;
								queue.add(nextNumber);
							}
							
						}//for0to9
						
					}//forstep
					
					if(visitiedMap[numberOfB]){
						System.out.println(step+1);
						queue.clear();
						break;
					}
					
				}//for QueueSize
				
			}
			
			if(!visitiedMap[numberOfB]){
				System.out.println("Impossible");
			}
			
		}//forTestCase

	}// main

}// class