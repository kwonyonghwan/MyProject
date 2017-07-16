package algorithm;

public class NHNTechnology3 {

	public static void main(String[] args) {
		
		int changeRate = 1322;
		int[][]  moneyOfN = new int[6][2];
		moneyOfN[0][0] = 1*changeRate;
		moneyOfN[1][0] = 5*changeRate;
		moneyOfN[2][0] = 10*changeRate;
		moneyOfN[3][0] = 20*changeRate;
		moneyOfN[4][0] = 50*changeRate;
		moneyOfN[5][0] = 100*changeRate;
		//1N = 1332
		moneyOfN[0][1] = 20;
		moneyOfN[4][1] = 4;	
		moneyOfN[5][1] = 4;
		
		int changeMoney = 1000000 - ((moneyOfN[5][0]+moneyOfN[4][0])*4) - (moneyOfN[0][0]*20);
		int stepNumber = 3;
		
		while(changeMoney>2000){
			if(changeMoney < moneyOfN[stepNumber][0]){
				stepNumber= (stepNumber+3) % 4;
				continue;
			}
			changeMoney -= moneyOfN[stepNumber][0];
			moneyOfN[stepNumber][1]++;
			stepNumber= (stepNumber+3) % 4;
		}//while
		
		for(int i=5; i>-1; i--){
			System.out.println( (moneyOfN[i][0]/changeRate)+"N: "+moneyOfN[i][1]+"¿Â");
		}
		System.out.println("\r¿‹µ∑ : "+changeMoney);
	
	}//main

}//class
