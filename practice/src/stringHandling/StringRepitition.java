package stringHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StringRepitition {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("src/stringHandling/StringRepitition.txt"));

		  
       // Scanner sc = new Scanner(System.in);
        
        int TC = sc.nextInt()+1;
        
        for(int testCase = 1; testCase<TC; testCase++){
            
            int countOfReplay = sc.nextInt();
            char[] charArray = sc.nextLine().toCharArray();
            
            for(int i=1; i<charArray.length; i++){
                for(int j=0; j<countOfReplay; j++){
                    System.out.print(charArray[i]);
                }
            }
             System.out.println();
        }//forTestCase
        
    }//main
}//class
