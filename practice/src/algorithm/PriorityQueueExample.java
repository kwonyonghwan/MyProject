package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

 class Prisoner implements Comparable<Prisoner> {
	
    String name;
    int weight; // Çü·®

    public Prisoner(String name, int weight) {
        super();
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Prisoner target) {
        if (this.weight > target.weight) {
            return 1;
        } else if (this.weight < target.weight) {
            return -1;
        }
        return 0;
    }
}


	
public class PriorityQueueExample {

	public static void main(String[] args) {
		
		  Prisoner prisoner1 = new Prisoner("james", 5);
		    Prisoner prisoner2 = new Prisoner("schofield", 99);
		    Prisoner prisoner3 = new Prisoner("alex", 14);
		    Prisoner prisoner4 = new Prisoner("silvia", 10);
		    Prisoner prisoner5 = new Prisoner("thomson", 1);

		    PriorityQueue<Prisoner> priorityQueue = new PriorityQueue<Prisoner>();

		    priorityQueue.offer(prisoner1);
		    priorityQueue.offer(prisoner2);
		    priorityQueue.offer(prisoner3);
		    priorityQueue.offer(prisoner4);
		    priorityQueue.offer(prisoner5);
		
		
		while(!priorityQueue.isEmpty()){
			Prisoner prisoner = priorityQueue.poll();
			System.out.println(prisoner.name);
		}
		
		
		
		
	}//main

	
	
}//class 

 