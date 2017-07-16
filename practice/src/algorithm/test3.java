package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.jar.Attributes.Name;

public class test3 {

	public static void main(String[] args) {
		
		System.out.println(name());
		
	}// main

	public static int name() {
		int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 21, 24, 26, 27, 28};

		int X = 28;
	
		    int N = A.length;
		    if (N == 0) {
		        return -1;
		    }
		    int l = 0;
		    int r = N - 1;
		    while (l <= r) {
		        int m = (l + r) / 2;
		        if (A[m] >= X) {
		            r = m+1 ;
		        } else {
		            l = m;
		        }
		        
		    }
		    
		    
		    if (A[l] == X) {
		        return l;
		    }
		    return -1;
		}//name
	



}// class




