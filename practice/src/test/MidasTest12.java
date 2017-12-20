package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidasTest12 {
	static int result = 0;
	static int N ;
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/test/MidasTest12.txt"));

		// Scanner sc = new Scanner(System.in);
		
		 N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		boolean[] roomList = new boolean[M+1];
	
		ArrayList<ArrayList<Integer>> hopeRoomList = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp0 = new ArrayList<>();
		hopeRoomList.add(temp0);	
		for(int i=0; i<N; i++	){
			
			ArrayList<Integer> temp = new ArrayList<>();
			int tempValue = sc.nextInt();
			temp.add(tempValue);
			for(int j=0; j<tempValue; j++){
				temp.add(sc.nextInt());
			}
			hopeRoomList.add(temp);
		}
		
		DFS(roomList, hopeRoomList, 0,0);
		
		
		System.out.println(result);

	}// main

	private static void DFS(boolean[] roomList, ArrayList<ArrayList<Integer>> hopeRoomList, int officeNumber, int roomCount) {
		
		 officeNumber++;
//		 System.out.println(hopeRoomList.get(officeNumber).size());
		
		 for(int i=1; i<hopeRoomList.get(officeNumber).size()-1; i++){
			 
			 if( !roomList[hopeRoomList.get(officeNumber).get(i)] ){
				 roomList[hopeRoomList.get(officeNumber).get(i)] = true;
				 roomCount++;
				 if(officeNumber !=N){
					 DFS(roomList, hopeRoomList, officeNumber,roomCount);
				 }
				 roomList[hopeRoomList.get(officeNumber).get(i)] = false;
			 }
			 
		 }
		 if(officeNumber < N){
			 DFS(roomList, hopeRoomList, officeNumber,roomCount);
		 }
		
		
		 result = Math.max(roomCount, result);
	}

}// class
