package knapsack01;

import java.util.Arrays;

/**
 * 
 * @author Saroye
 * given an array, we have to divide the array into 2 sub arrays.
 * we have to make sure that sum1-sum2= minimun. 
 * (absolute difference should minimum).
 */
public class minSubsetSum {
	
	
	public int absoluteMinValue(int[] ar) {
		int sum=0;
		int min=Integer.MAX_VALUE;
		for(int i :ar) {
			sum=sum+i;
		}
		int[] vector= this.subSetSum(ar,sum);
		System.out.println("Vector: "+Arrays.toString(vector));
		for(int i=0; i<vector.length; i++) {
			min=Math.min(min, sum-(2*vector[i]));
		}
		return min;
	}
	
	public int[] subSetSum( int[] ar, int sum) {
		boolean[][] t =new boolean[ar.length+1][sum+1];
		int[] v=new int[t[0].length/2];
		for(int i=0; i<t[0].length; i++) {
			t[0][i]=false;
		}
		for(int j=0; j<t.length; j++) {
			t[j][0]=true;
		}
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {
				if(j>=ar[i-1]) {
					t[i][j]= 
							(t[i-1][j-ar[i-1]] ||	
							 t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		for(int i=0; i<v.length; i++) {
			if(t[t.length-1][i]==true) {
				v[i]=i;
			}
			else {
				v[i]=-1;
			}
		}
		return v;
	}
	
	public int countOfSubSetWGivenDiff(int[] ar, int diff) {
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
		return t[ar.length][sum];
	}
	
	public static void main(String[] args) {
		minSubsetSum m = new minSubsetSum();
		int[] ar = {1,2,7};
		int[] ar1 = {1,1,2,3};
		int diff=1;
		System.out.println("Array: "+Arrays.toString(ar));
		System.out.println("min absolute sum from 2 subsets: "+m.absoluteMinValue(ar));

		System.out.println("Array2: "+Arrays.toString(ar1));
		System.out.println("Number of 2 subsets whose difference is: "+ diff+ " is: "+m.countOfSubSetWGivenDiff(ar1, diff));
	}

}
