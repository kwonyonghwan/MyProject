package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/sorting/Sorting.txt"));

//		Scanner sc = new Scanner(System.in);

		Queue<ArrayList<Integer>> queue = new LinkedList<>(); 

		while (sc.hasNext()){
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(sc.nextInt());
			queue.offer(temp);
		}
		System.out.println(queue.toString());
		
		while(queue.size()>1){
			ArrayList<Integer> arr1 = queue.poll();
			ArrayList<Integer> arr2 = queue.poll();
			ArrayList<Integer> arr3 = new ArrayList<>();
			int size = arr1.size()+arr2.size();
			for(int i=0; i<size; i++){
				int arr1Temp = arr1.size()>0?arr1.get(0):Integer.MAX_VALUE;
				int arr2Temp = arr2.size()>0?arr2.get(0):Integer.MAX_VALUE;
				if(arr1Temp > arr2Temp){
					arr3.add(arr2.get(0));
					arr2.remove(0);
				}else{
					arr3.add(arr1.get(0));
					arr1.remove(0);
				}
			}
			
			queue.offer(arr3);
			System.out.println(queue.toString());
			
		}//while
		
		
	}//main
	
}// class
