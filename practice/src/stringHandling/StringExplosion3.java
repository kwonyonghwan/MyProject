package stringHandling;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplosion3 {

	public static void main(String[] args) throws IOException {

		// BufferedReader br=new BufferedReader(new
		// InputStreamReader(System.in));

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/stringHandling/StringExplosion.txt")));
		Stack<Character> stack = new Stack<Character>();
		String inputString = br.readLine();
		String explosion = br.readLine();
		
		for (int i = inputString.length()-1; i >-1; i--) {
			stack.push(inputString.charAt(i));

			if(stack.size()>=explosion.length() &&stack.peek()==explosion.charAt(0)){
				boolean isExplosion =true;
				
				for(int j=1 ; j<explosion.length(); j++){
					if(stack.get(stack.size()-j-1)!=explosion.charAt(j)){
						isExplosion = false;
						break;
					}
				}

				if(isExplosion){
				for(int j=0; j<explosion.length(); j++){
					stack.pop();
				}
				}
			}
			
		}//forKMPSearch
		
		StringBuffer buffer = new StringBuffer();
		if (stack.size() > 0) {
			while(!stack.isEmpty()){
				buffer.append(stack.pop());
			}
			System.out.println(buffer);
		} else {
			System.out.println("FRULA");
		}

	}// main

}// class
