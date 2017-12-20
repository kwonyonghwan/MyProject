package teaching;

import java.io.FileNotFoundException;
import java.util.Stack;import algorithm.Templet1;

public class NextNextLine4 {

	public static void main(String[] args) throws FileNotFoundException {

		Stack<Integer> tempStack = new Stack<>();
		
		tempStack.add(1);
		tempStack.add(5);
		tempStack.add(8);
		tempStack.add(2);
		tempStack.add(3);
		tempStack.add(4);
		System.out.println(tempStack.toString());
		
/*		System.out.println(tempStack.size());
		
		System.out.println(tempStack.get(2));
	
		System.out.println(tempStack.pop());
		System.out.println(tempStack);
		System.out.println(tempStack.peek());
*/		
		tempStack.sort(null);
		
		System.out.println(tempStack);
		
		
		
		
	}//main

}//class
