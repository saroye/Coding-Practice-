package knapsack01;

import java.util.Arrays;

/**
 * 
 * @author Saroye
 *
 *	is their a subset in an array which is equal to the given sum
 *	count all of these types of subset.
 */
public class countOfSubset {
	
	
	public int subsetCount(int[] ar, int sum, int n) {
		int[][] t= new int[ar.length+1][sum+1];
		
		for(int i=0; i<t.length; i++) {
			t[0][i]=0;
		}
		for(int j=0; j<t.length; j++) {
			t[j][0]=1;
		}
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[0].length; j++) {
				if(ar[i-1]<=j) {
					t[i][j]= t[i-1][j-ar[i-1]]+t[i-1][j];
				}
				else {
					t[i][j]=  t[i-1][j];
				}
			}
		}
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return t[ar.length][sum];
	}
	
	
	
	public static void main(String[] args) {
		countOfSubset s = new countOfSubset();
		int [] ar =  {2,3,4,6,8,10};
		int sum=10;
		System.out.println("Array: "+Arrays.toString(ar));
		System.out.println("sum:   "+sum);
		System.out.println("Count of subsets: "+s.subsetCount(ar, sum, ar.length));
	}
}
