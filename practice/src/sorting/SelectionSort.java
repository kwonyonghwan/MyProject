package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/sorting/Sorting.txt"));

//		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numberList = new ArrayList<>();
		
		while(sc.hasNext()){
			numberList.add(sc.nextInt());
		}
		System.out.println(numberList.toString());
		
		for(int i=0; i<numberList.size(); i++){
			int temp = numberList.get(i);
			int tempIndex = i;
			
			for(int j=i; j<numberList.size(); j++){
				if(numberList.get(j)<temp){
					temp = numberList.get(j);
					tempIndex = j;
				}
			}
			
			numberList.set(tempIndex, numberList.get(i));
			numberList.set(i, temp);

			System.out.println(numberList.toString());
		}//forSorting
		
		
		
	}

}// class
