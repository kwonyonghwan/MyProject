package stringHandling;

public class ManacherAlgorithm {

	public static void main(String[] args) {

		String inputString = "banana";
		int index = 10;
		
		int[] A = new int[index];
		char[] S = new char[index];
		
		int r=-1; 
		int p=0-1;
		for(int i=0; i<=5; i++){
			if(i<=r){
				A[i] = Math.min(A[2*p-i], r-i);
			}else{
				A[i]=0;
			}
			
			while((i-A[i]-1)>-1 && i+A[i]+1<10&&
					S[i-A[i]-1]==S[i+A[i]+1]){
				A[i]++;
				if(i+A[i]>r){
					r = i+A[i];
					p=i;
				}
				
			}//while
			
		}//forI
		
		System.out.println();
	}//main

}//class
