package algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.omg.PortableInterceptor.INACTIVE;
 class set{
	 int lenth;
	 int index;
	
}

public class test1 {

	public static void main(String[] args) throws FileNotFoundException {

	
		
		int sum = 0;
		
		
		
		for(int i=1; i<11; i++){
			sum = sum+ (i*(i+1));
		}
		for(int i=1; i<10; i++){
			sum = sum+ (i*(i+1));
		}
		for(int i=1; i<9; i++){
			sum = sum+ (i*(i+1));
		}
		
		for(int j=1; j<11; j++){
		for(int i=1; i<=j; i++){
			sum = sum+ (i*(i+1));
		}
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	/*	
		Set<int[]> testSet = new HashSet<int[]>();
		int[] testa = {2,3,4};
		int[] testb = {4,3,2};
		int[] testc = {2,3,5};
		int[] testd = {2,3,5};
		testSet.add(testa);
		testSet.add(testb);
		testSet.add(testc);
		testSet.add(testd);
		
		for(java.util.Iterator<int[]> i= testSet.iterator(); i.hasNext();){
			int[] temp = i.next();
			for(int j=0; j<temp.length; j++){
				System.out.print(temp[j]);
			}
			System.out.println();
		}
		
		*/
		
		
		
		
	/*	PriorityQueue<Integer> tesQueue = new PriorityQueue<>();
		
		tesQueue.offer(1);
		tesQueue.offer(1);
		tesQueue.offer(2);
		
		while(!tesQueue.isEmpty()){
			System.out.println(tesQueue.poll());
		}*/
		
			/*String temp = sc.nextLine();
		System.out.println(temp);
		
		char test = '1';
		
		set temp1 = new set();
		temp1.lenth = 4;
		temp1.index = 5;
		
		set temp2 = new set();
		temp2.lenth = 2;
		temp2.index = 8;
		
		set temp3 = new set();
		temp2.lenth = 9;
		temp2.index = 2;

		boolean odd = true;
		System.out.println(odd);
		odd = !odd;
		System.out.println(odd);
		*/
		

	/*	TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
		//TreeSet<Integer> tree = new TreeSet<>();
		
		tree.put(1, 6);
		
		tree.put(3, 39);
		tree.put(2, 99);
		tree.put(4, 2);
		tree.put(5,17);
		tree.put(6,15);
		tree.put(7, 12);
		System.out.println(tree.toString());
		
		System.out.println("adsfasdfasdf"+Math.atan2(30, 30) * (180/Math.PI));
		
		System.out.println(Math.PI);
		int[] test = new int[2];
		
		for (int i : test) {
			i = 9;
		}
		
		System.out.println(test[0]);
		System.out.println(test[1]);*/
	}
	//}
	/*	// TODO Auto-generated method stub
		long dTest = 35355353545L;

		double temp = Double.POSITIVE_INFINITY;
		boolean[] booltest = new boolean[5];
		System.out.println(booltest[3]);

		int[] test = new int[4];

		test[0] = 3;
		test[1] = 7;
		test[2] = 2;
		test[3] = 9;

		Arrays.sort(test);

		System.out.println("test[0]" + test[0]);

		PriorityQueue<Integer> priQueue = new PriorityQueue<Integer>();

		priQueue.offer(5);

		priQueue.offer(4);

		priQueue.offer(3);
		priQueue.offer(2);
		priQueue.offer(1);
		priQueue.offer(6);

		while (!priQueue.isEmpty()) {
			System.out.println(priQueue.poll());
		}

		System.out.println(priQueue.toString());

		int r = 0;

		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(1);
		qu.offer(2);
		qu.offer(3);
		qu.offer(4);
		System.out.println("3/5" + (double) 3 / 5);

		System.out.println(qu.size());

		for (int i = 0; i < 4; i++) {
			tet();
		}

		System.out.println(checkNumber(16));

	}

	public static void tet() {
		System.out.println("adf");
	}

	
	 * package algorithm;
	 * 
	 * import java.io.FileInputStream; import java.io.FileNotFoundException;
	 * import java.util.Scanner;
	 * 
	 * public class Subarray {
	 * 
	 * public static void main(String[] args) throws FileNotFoundException {
	 * Scanner sc = new Scanner(new
	 * FileInputStream("src/algorithm/Subarray.txt"));
	 * 
	 * int T; int test_case;
	 * 
	 * T = sc.nextInt(); for (test_case = 1; test_case <= T; test_case++) {
	 * 
	 * int numberOfArray = sc.nextInt(); int sumOfSubarray = sc.nextInt();
	 * 
	 * int[] array = new int[numberOfArray];
	 * 
	 * int minSubArrayLength = numberOfArray+1; int stepSubArrayLength = 0; int
	 * sumOfStepArray = 0;
	 * 
	 * for(int i=0; i<numberOfArray; i++){ array[i] = sc.nextInt(); }//forI
	 * 
	 * 
	 * for(int i=0; i<numberOfArray; i++){
	 * 
	 * sumOfStepArray = 0; stepSubArrayLength = 0;
	 * 
	 * for(int j=i; j<numberOfArray; j++){ sumOfStepArray += array[j];
	 * stepSubArrayLength++;
	 * 
	 * 
	 * 
	 * if(sumOfStepArray > sumOfSubarray){ if(minSubArrayLength >
	 * stepSubArrayLength){ minSubArrayLength = stepSubArrayLength; } break; }
	 * 
	 * }//forJ }//forI
	 * 
	 * 
	 * System.out.println(minSubArrayLength);
	 * 
	 * 
	 * 
	 * }//forT }//main
	 * 
	 * }//class
	 */

	private static int pow(int i, int x) {
		
		
		for(int j=0;j<x; j++){
			i= i*i;
		}
		
		return i;
	}

	public static int checkNumber(int num) {
		int tempnum = 2;
		int cnt = 1;
		while (!(tempnum == num)) {
			tempnum = tempnum << 1;
			cnt++;
		}
		return cnt;
	}
}
