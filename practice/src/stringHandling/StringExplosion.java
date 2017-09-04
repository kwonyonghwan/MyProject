package stringHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringExplosion {

	public static void main(String[] args) throws IOException {

//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("src/stringHandling/StringExplosion.txt")));
		
		StringBuffer inputString = new StringBuffer(" " + br.readLine());
		String explosion = " " + br.readLine();

		int[] piArray = new int[explosion.length()];
		for (int i = 1; i < explosion.length(); i++) {
			int lengthOfSubsequence = 0;
			for (int j = 1; j <= (i / 2); j++) {
				if (explosion.substring(1, 1 + j).equals(explosion.substring(i + 1 - j, i + 1))) {
					lengthOfSubsequence = Math.max(j, lengthOfSubsequence);
				}
			}
			piArray[i] = lengthOfSubsequence;
		} // forMakePiArray

		for (int index = 1; index < (inputString.length() - (explosion.length() - 2)); index++) {

			boolean nextMoreFlag = false;
			int nextMore = 0;
			for (int i = nextMoreFlag?1:1+nextMore; i < explosion.length(); i++) {
				if (inputString.charAt(index + i - 1) != explosion.charAt(i)) {
					nextMoreFlag = false;
					if(piArray[i-1]>0){
						nextMoreFlag=true;
						nextMore = i;
					index += (i - 2 - piArray[i - 1]);
					}
					break;
				}//noSearch

				if (i == explosion.length() - 1) {
					inputString.delete(index, index + i);
					if (index - (explosion.length() - 1) > -1) {
						index -= (explosion.length() - 1);
					} else {
						index = 0;
					}

				}//findExplotion

			}
		}//forKMPSearch
		
		BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
		if (inputString.length() > 1) {
			bw.write(inputString.delete(0, 1).toString());
			bw.flush();
		} else {
			System.out.println("FRULA");
		}

	}// main

}// class
