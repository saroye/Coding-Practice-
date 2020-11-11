package DynamicProgramming;
import java.util.*;

/**
 * 
 * @author Saroye
 *
 *	given an array an int n
 *	return if a subset in the given array
 *	has a sum of n value
 */
public class subsetSum {

	public boolean subSetSum( int[] ar, int sum) {
		boolean[][] t =new boolean[ar.length+1][sum+1];
		for(int i=0; i<t.length; i++) {
			t[i][0]=false;
		}
		for(int j=0; j<t.length; j++) {
			t[j][0]=true;
		}
		for(int i=1; i<=t.length; i++) {
			for(int j=1; j<=t[i].length; j++) {
				
				if(ar[i-1]<=j) {
					t[i][j]= (t[i][j-ar[i-1]] ||t[i-1][j]);
				}
				else {
					t[i][j]=t[i-1][j];
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
		int [] val = new int [] {2,3,4,5};
		int n=12;
		System.out.println("sum: "+n+" Array: "+Arrays.toString(val));
		s.subSetSum(val, 8);
	}
}
