package com.plus.util;

public class PeopleNumberByCategory {
	
	public static int PeopleNumberByCategory(String category){

		int peopleNumber=0;
		
		switch (category) {
		case "������":
			peopleNumber = 3;
			break;
		case "���":
			peopleNumber = 2;
			break;
		case "��ȭ":
			peopleNumber = 2;
			break;
		case "����":
			peopleNumber = 2;
			break;
		default:
			break;
		}
		
		return peopleNumber;
	}//switch
	
}//class
