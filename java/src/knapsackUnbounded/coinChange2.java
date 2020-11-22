package knapsackUnbounded;

import java.util.Arrays;

/**
 * 
 * min number of coins used to get sum.
 * @author Saroye
 *
 */
public class coinChange2 {

	public int change(int[] coins, int sum) {
		int[][] t= new int[coins.length+1][sum+1];

		for(int j=0; j<t.length; j++) {
			t[j][0]=0;
		}
		for(int i=0; i<t[0].length; i++) {
			t[0][i]=Integer.MAX_VALUE-1;
		}
		for(int i=1; i<t[0].length; i++) {
			if(i%coins[0]==0) {
				t[1][i]=i/coins[0];
			}
			else {
				t[1][i]=Integer.MAX_VALUE-1;
			}
		}
		
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {

				if(coins[i-1] <=j) {
					t[i][j]=  Math.min(t[i][j-coins[i-1]]+1, t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		
		System.out.println("_____________________________________________");
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println("_____________________________________________");
		return t[coins.length][sum];
	}
	
	public static void main(String[] args) {
		coinChange2 c = new coinChange2();
		int[] coins = {1,2,3}; 
		int sum=5;
		System.out.println("Coins: "+Arrays.toString(coins));
		System.out.println(c.change(coins, sum));
		
		
	}
}
