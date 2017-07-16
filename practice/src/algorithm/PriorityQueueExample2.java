package algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

class Vertex implements Comparable<Vertex>{
	int vertexNumber;
	int vertexWeight;
	
	public Vertex(int vevertexNumber, int vertexWeight){
		super();
		this.vertexNumber = vevertexNumber;
		this.vertexWeight = vertexWeight;
	}

	@Override
	public int compareTo(Vertex target) {
		 if (this.vertexWeight > target.vertexWeight) {
	            return 1;
	        } else if (this.vertexWeight < target.vertexWeight) {
	            return -1;
	        }
	        return 0;
	}
	
}

public class PriorityQueueExample2 {

	public static void main(String[] args) {
		
		PriorityQueue<Vertex> priQueue = new PriorityQueue<Vertex>();
		
		Vertex v1 = new Vertex(1, 3);

		Vertex v2 = new Vertex(2, 2);

		Vertex v3 = new Vertex(3, 8);
		Vertex v4 = new Vertex(4, 1);
		Vertex v5 = new Vertex(5, 4);
		Vertex v6 = new Vertex(6, 3);


		priQueue.offer(v1);
		priQueue.offer(v2);
		priQueue.offer(v3);
		priQueue.offer(v4);
		priQueue.offer(v5);
		priQueue.offer(v6);
		
		while (!priQueue.isEmpty()) {
			Vertex temp = priQueue.poll();
			System.out.println(temp.vertexNumber);
		}
		
	}

}
