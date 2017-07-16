package simulation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Card1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		 int numberOfLastCard = 7;
	        Queue<Integer> queue = new LinkedList<Integer>();
	        for(int i=1; i<numberOfLastCard+1; i++){
	            queue.offer(i);
	        }
	        
	        while(queue.size()==1){
	            System.out.print(queue.poll()+" ");
	            queue.offer(queue.poll());
	        }
	        System.out.print(queue.poll()+" ");
		
	}// main

}// class
