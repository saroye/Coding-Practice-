package knapsack01;

import java.util.Arrays;

/**
 * 
 * given an array element, assign a sign (+/-).
 * so that the sum is 1.
 *  
 * @author Saroye
 *
 */
public class TargetSum {
	
	
	
	public int targetsum(int[] ar, int diff) {
		int sum=0;
		for(int i :ar) {
			sum=sum+i;
		}
		int count=(diff+sum)/2;
		return this.subsetCount(ar,count,ar.length);
	}
	
	public int subsetCount(int[] ar, int sum, int n) {
		int[][] t= new int[ar.length+1][sum+1];
		
		for(int i=0; i<t.length; i++) {
			t[i][0]=0;
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
		for (int j = 0; j < t.length; j++) {
			System.out.println(Arrays.toString(t[j]));
		}
		return t[ar.length][sum];
	}
	
	public static void main(String[] args) {
		
		TargetSum t = new TargetSum();
		int[] ar = {1,2,7};
		System.out.println(t.targetsum(ar,1));
		
		
	}

}
