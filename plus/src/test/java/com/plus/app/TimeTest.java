package com.plus.app;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date time = new Date();
		System.out.println(time);
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("dd¿œ");
		System.out.println(dayFormat.format(time));
		String test = 	dayFormat.format(time);
		System.out.println(test);
	}

}
