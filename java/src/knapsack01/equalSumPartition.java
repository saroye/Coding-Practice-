package knapsack01;

import java.util.Arrays;

/**
 * @author Saroye
 *	
 *	given an array: divide in two subset
 * 	so that both of the subset have same sum
 * 	return true or false;
 */

public class equalSumPartition {
	
	
	public boolean isEqualSumPartition(int[] ar, int sum, int n) {
		int ans=0;
		int[][] t = new int[ar.length+1][sum+1];
		
		for(int i=0; i<n; i++) {
			ans=ans+ar[i];
		}
		if(ans%2!=0) {
			return false; 
		}
		else if(ans%2==0) {
			return SubsetSum(ar,n,sum/2);
		}
		return false;
	}
	public  boolean SubsetSum(int set[],int n, int sum)
	{
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}
		if (set[n - 1] > sum) {
			return SubsetSum(set, n - 1, sum);
		}
		return SubsetSum(set, n - 1, sum) || SubsetSum(set, n - 1, sum - set[n - 1]);
	}
	
	public static void main(String[] args) {
		
		equalSumPartition e = new equalSumPartition();
		int[] ar = new int[] {1,5,5,11,5};
		System.out.println("Array: "+Arrays.toString(ar));
		System.out.println(e.isEqualSumPartition(ar, 11, ar.length));
	}

}
