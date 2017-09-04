package stringHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StringExplosion2 {

	public static void main(String[] args) throws IOException {

//		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("src/stringHandling/StringExplosion.txt")));
		
		StringBuffer inputString = new StringBuffer(" " + br.readLine());
		String explosion = " " + br.readLine();

		for (int index = explosion.length()-1; index < inputString.length(); index++) {

			if(inputString.charAt(index)== explosion.charAt(explosion.length()-1)){
				boolean isExplosion =true;
				for(int j=1 ; j<explosion.length()-1; j++){
					if(inputString.charAt(index-j)!=explosion.charAt(explosion.length()-1-j)){
						isExplosion = false;
						break;
					}
				}

				if(isExplosion){
					inputString.delete(index-(explosion.length()-2), index + 1);
					index-=(explosion.length()-1);
				}
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
