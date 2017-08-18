package com.plus.util;

public class PeopleNumberByCategory {
	
	public static int PeopleNumberByCategory(String category){

		int peopleNumber=0;
		
		switch (category) {
		case "πËµÂπŒ≈œ":
			peopleNumber = 3;
			break;
		case "µÓªÍ":
			peopleNumber = 2;
			break;
		case "øµ»≠":
			peopleNumber = 2;
			break;
		case "ø¨±ÿ":
			peopleNumber = 2;
			break;
		default:
			break;
		}
		
		return peopleNumber;
	}//switch
	
}//class
