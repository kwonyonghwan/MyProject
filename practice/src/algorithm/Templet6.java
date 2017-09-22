package algorithm;

import java.util.ArrayList;

class object {
	public object(String string, boolean b) {
		this.value = string;
		this.pair = b;
	}

	String value;
	boolean pair;
}

public class Templet6 {
	public static void main(String[] args) {
		String str1 = "E=M*C^2";
		String str2 = "e=m*c^2";
		int answer = 0;
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		ArrayList<String> str1List = new ArrayList<>();
		ArrayList<String> str2List = new ArrayList<>();
		
		str1List = getSubString(str1);
		str2List = getSubString(str2);
		for (int j = 0; j < str2List.size(); j++) {
			System.out.print(" "+str2List.get(j));
		}
		System.out.println();
		
		
		double unionValue = getUnionCount(str1List, str2List);
		double complementValue = getComplement(str1List, str2List);
		System.out.println(unionValue +" "+complementValue );
		if(unionValue==0.0 && complementValue==0.0){
			System.out.println(65536);
		}
		
		
		double result = complementValue/unionValue;
		
		System.out.println(result);
		answer = (int) (result *65536);
	
		System.out.println(answer);
	}// main고려대학교

	public static ArrayList<String> getSubString(String inputString) {
		ArrayList<String> tempList = new ArrayList<>();
	//	String[] tempList = new String[inputString.length() - 1];
		for (int i = 0; i < inputString.length() - 1; i++) {
			String temp = "";
			if ((int) inputString.charAt(i) > 96 && (int) inputString.charAt(i) < 123&&(int) inputString.charAt(i+1) > 96 && (int) inputString.charAt(i+1) < 123) {
				temp += inputString.charAt(i);
				temp += inputString.charAt(i + 1);
			} else {
				continue;
			}
			tempList.add(temp);
		}
		return tempList;
	}

	private static int getUnionCount(ArrayList<String> str1List, ArrayList<String> str2List) {
		int CountOfUnion = 0;

		ArrayList<object> unionString = new ArrayList<>();
		//FR, RA, AN, NC, CE, RE, EN, CH}
		for (int i = 0; i < str1List.size(); i++) {
			object temp = new object(str1List.get(i), false);
			unionString.add(temp);
		}
		for (int i = 0; i < str2List.size(); i++) {
			boolean noMatching = true;
			for (int j = 0; j < unionString.size(); j++) {
				if (unionString.get(j).value.equals(str2List.get(i)) && !unionString.get(j).pair) {
					unionString.get(j).pair = true;
					noMatching = false;
					break;
				}
			}
			if (noMatching) {
				unionString.add(new object(str2List.get(i), false));
			}
		}

		
		for (int j = 0; j < unionString.size(); j++) {
			System.out.print(" "+unionString.get(j).value);
		}
		System.out.println();
		return unionString.size();
	}

	private static int getComplement(ArrayList<String> str1List, ArrayList<String> str2List) {
		int CountOfComplement = 0;

		ArrayList<object> complementString = new ArrayList<>();

		for (int i = 0; i < str1List.size(); i++) {
			object temp = new object(str1List.get(i), false);
			complementString.add(temp);
		}

		for (int i = 0; i < str2List.size() ; i++) {
			for (int j = 0; j < complementString.size(); j++) {
				if (complementString.get(j).value.equals(str2List.get(i)) && !complementString.get(j).pair) {
					complementString.get(j).pair = true;

					break;
				}
			}
		}
		
		int result = 0;
		for (int j = 0; j < complementString.size(); j++) {
			if(complementString.get(j).pair){
				result++;
			}
		}

		return result;
	}

}// class