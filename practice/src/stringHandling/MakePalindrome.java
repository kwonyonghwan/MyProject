package stringHandling;

import java.util.Scanner;

public class MakePalindrome {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String inputString = "aaabc";
		//String inputString = sc.nextLine();
/*		String reverseString = new StringBuffer(inputString).reverse().toString();

		char[] inputChar = inputString.toCharArray();
		char[] reverseChar = reverseString.toCharArray();

		boolean findShortest = false;
		int index = inputString.length();
	
		for (int i = 0; i < inputString.length(); i++) {
			int indexReverse = 0;
			if (findShortest) {
				break;
			}
			for (int k = i; k < inputString.length(); k++) {

				if (inputChar[k] != reverseChar[indexReverse]) {
					break;
				}
				if (k == inputString.length() - 1 && inputChar[k] == reverseChar[indexReverse]) {
					findShortest = true;
					index = i;
				}
				indexReverse++;
			} // forK
		} // forI

		for (int i = 0; i < index; i++) {
			System.out.print(inputChar[i]);
		}
		for (int i = 0; i < reverseChar.length; i++) {
			System.out.print(reverseChar[i]);
		}
		
		System.out.println(index + reverseChar.length);
		
		*/
		

        
        char[] inputCharArray = inputString.toUpperCase().toCharArray(); 
        int[] countAlphabet = new int[91];
        
        for(int i=0; i<inputCharArray.length; i++){
            countAlphabet[(int)inputCharArray[i]]++;
        }
        
        for(int i=65; i<91; i++){
            System.out.print(countAlphabet[i]+" ");
        }
        
		
		

	}// main
}// class
