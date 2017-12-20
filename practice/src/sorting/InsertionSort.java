package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/sorting/Sorting.txt"));

//		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numberList = new ArrayList<>();
		
		while(sc.hasNext()){
			numberList.add(sc.nextInt());
		}
		System.out.println(numberList.toString());
		for(int i=1; i<numberList.size(); i++){
			int searchIndex = i-1;
			while(searchIndex>-1 && numberList.get(searchIndex)>numberList.get(searchIndex+1)){
				int temp = numberList.get(searchIndex);
				numberList.set(searchIndex, numberList.get(searchIndex+1));
				numberList.set(searchIndex+1, temp);
				searchIndex--;
			}
			System.out.println(numberList.toString());
		}

	}

}// class
