package test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// String inputString = sc.nextLine();
		String inputString = "dencrypt secretword 3 cspkfcgzin";
		String[] inputStringList = inputString.split(" ");
		String resultString = "";

		if (inputStringList[0].equals("encrypt")) {

			for (int i = 0; i < inputStringList[3].length(); i++) {
				char temp = (char) (((((int) inputStringList[1].charAt(i) - 97)
						+ ((int) inputStringList[3].charAt(i) - 97)) % 26 + 97));
				resultString = resultString + temp;
			}

			StringBuilder temp = new StringBuilder(resultString);
			int rotateNumber = Integer.parseInt(inputStringList[2]);
			if (rotateNumber > -1) {
				String temp2 = temp.substring(0, rotateNumber);
				temp.delete(0, rotateNumber);
				temp.append(temp2);
			} else {
				String temp2 = temp.substring(temp.length() + rotateNumber, temp.length());
				temp = new StringBuilder(temp.substring(0, temp.length() + rotateNumber));
				temp = new StringBuilder(temp2 + temp);
			}
			resultString = temp.toString();
		} else {

			StringBuilder temp = new StringBuilder(inputStringList[3]);
			int rotateNumber = Integer.parseInt(inputStringList[2]);
			if (rotateNumber < -1) {
				String temp2 = temp.substring(0, -rotateNumber);
				temp.delete(0, -rotateNumber);
				temp.append(temp2);
			} else {
				String temp2 = temp.substring(temp.length() - rotateNumber, temp.length());
				temp = new StringBuilder(temp.substring(0, temp.length() - rotateNumber));
				temp = new StringBuilder(temp2 + temp);
			}

			resultString = temp.toString();

			String resultTemp = "";

			for (int i = 0; i < inputStringList[3].length(); i++) {
				int tempInt = (((int) resultString.charAt(i) - 97) - ((int) inputStringList[1].charAt(i) - 97));
				char temp1;
				if (tempInt < 0) {
					temp1 = (char) (tempInt + 26 + 97);
				} else {
					temp1 = (char) (tempInt + 97);
				}
				resultTemp = resultTemp + temp1;
			}
			resultString = resultTemp;
		}//Decrytion

		System.out.println(resultString);

	}// main

}// class
