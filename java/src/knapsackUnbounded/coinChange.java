package knapsackUnbounded;

import java.util.Arrays;


/**
 * max number of ways to get sum by given number of coins
 * @author Saroye
 *
 */
public class coinChange {


	public int change(int[] coins, int sum) {

		int[][] t= new int[coins.length+1][sum+1];

		for(int j=0; j<t.length; j++) {
			t[j][0]=1;
		}
		for(int i=0; i<t[0].length; i++) {
			t[0][i]=0;
		}
		
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {

				if(coins[i-1] <=j) {
					t[i][j]=  t[i][j-coins[i-1]] + t[i-1][j];
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

		coinChange c = new coinChange();
		int[] coins = {1,2,3,4,5,6,7,8}; 
		int sum=4;
		System.out.println("Coins: "+Arrays.toString(coins));
		System.out.println(c.change(coins, sum));
	}
}
