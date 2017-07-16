package dfs;

import java.util.Stack;

public class dfsTest3 {

	public static void main(String[] args) {
		
		Stack<testStructure> stack = new Stack<testStructure>();
		
		testStructure test1 = new testStructure();
	
		stack.push(test1);
		 System.out.println(stack.pop());

	}
	
	public static class testStructure{
		static int int1 = 1;
	}

}
