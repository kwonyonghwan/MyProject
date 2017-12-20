package sorting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(new FileInputStream("src/sorting/Sorting.txt"));

//		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> numberList = new ArrayList<>();
		
		while(sc.hasNext()){
			numberList.add(sc.nextInt());
		}	System.out.println(numberList.toString());
		
		for(int i=numberList.size()-1; i>0; i--){
			for(int j=1; j<=i; j++){
				if(numberList.get(j-1)>numberList.get(j)){
					int temp = numberList.get(j-1);
					numberList.set(j-1, numberList.get(j));
					numberList.set(j, temp);
				}
			}
			System.out.println(numberList.toString());
		}//forSorting
		
		
		
	}

}// class
