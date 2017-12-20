package teaching;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NextNextLine2 {

	public static void main(String[] args) throws FileNotFoundException {

		int[] array = new int[1];
		array[0] = 1;
		
		ArrayList<Integer> tempArrayList = new ArrayList<>();

		tempArrayList.add(3);
		System.out.println(tempArrayList);
		tempArrayList.add(2);
		System.out.println(tempArrayList);
		tempArrayList.add(3);
		System.out.println(tempArrayList);
		tempArrayList.add(4);
		System.out.println(tempArrayList);
		
		System.out.println(tempArrayList.size());
		
		System.out.println(tempArrayList.indexOf(3));
		
		System.out.println(tempArrayList.get(1));
		 
		tempArrayList.remove(2);
		System.out.println(tempArrayList);
		
	}//main

}//class
