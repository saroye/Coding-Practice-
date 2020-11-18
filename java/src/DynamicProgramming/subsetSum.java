package DynamicProgramming;
import java.util.*;

/**
 * 
 * @author Saroye
 *
 *	given an array and int n
 *	return if a subset in the given array
 *	has a sum of n value
 */
public class subsetSum {

	public  boolean isSubsetSum(int set[],int n, int sum)
	{
		// Base Cases
		if (sum == 0) {
			return true;
		}
		if (n == 0) {
			return false;
		}
		// If last element is greater than sum, then ignore it
		if (set[n - 1] > sum) {
			return isSubsetSum(set, n - 1, sum);
		}
		/* else, check if sum can be obtained  by any of the following	(a) including the last element
			(b) excluding the last element */
		return isSubsetSum(set, n - 1, sum) || isSubsetSum(set, n - 1, sum - set[n - 1]);
	}

	public boolean subSetSum( int[] ar, int sum) {
		boolean[][] t =new boolean[ar.length+1][sum+1];
		
		for(int i=0; i<t[0].length; i++) {
			t[0][i]=false;
		}
		for(int j=0; j<t.length; j++) {
			t[j][0]=true;
		}
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {

				if(ar[i-1]<=j) {
					t[i][j]= 
							(
								t[i][j-ar[i-1]] 
								||
								t[i-1][j]
							);
				}
				else {
					t[i][j]=t[i][j-1];
				}
			}
		}
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}

		return t[ar.length][sum];
	}

	public static void main(String[] args) {
		subsetSum s = new subsetSum();
		int [] val = new int [] {1,3,4,10};
		int n=12;
		System.out.println("Array: 	   "+Arrays.toString(val));
		System.out.println("sum: 	   "+n);
		System.out.println("Recursive: "+s.isSubsetSum(val,val.length, n));
		System.out.println("Iterative: "+s.subSetSum(val, n));
	}
}
