package DynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author Saroye
 *
 *	is their a subset in an array which is equal to the given sum
 *	count all of these types of subset.
 */
public class countOfSubset {
	
	
	public boolean subsetCount(int[] ar, int sum, int n) {
		
		
		
		return false;
	}
	
	
	
	public static void main(String[] args) {
		countOfSubset s = new countOfSubset();
		int [] ar = new int [] {2,3,4,6,8,10};
		System.out.println("Array: "+Arrays.toString(ar));
		System.out.println("Count of subsets: "+s.subsetCount(ar, 10, ar.length));
	}
}
