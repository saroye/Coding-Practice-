package knapsackUnbounded;

import java.util.Arrays;

/**
 * 
 *  unbounded knapsack
 * @author Saroye
 *
 */
public class rodCutting {

	public int iterative(int[] price, int[]len, int n) {
		
		int[][] t = new int[price.length+1][n+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[i].length; j++) {

				if(i==0 || j==0) {
					t[i][j]=0;
				}
				else if(len[i-1] <=j) {
					t[i][j]=Math.max
							(
								price[i-1] + t[i][j-len[i-1]],
								t[i-1][j]
							);
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
		return t[price.length][n];
	}

	public static void main(String[] args) {

		rodCutting rc = new rodCutting();
		int[] price = {1, 5, 8, 9, 10, 17, 17, 20}; 
		int[] len= {1,2,3,4,5,6,7,8};
		int n=price.length;
		System.out.println(rc.iterative(price, len,n));

	}

}
