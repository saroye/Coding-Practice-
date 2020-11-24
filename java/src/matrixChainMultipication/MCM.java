package matrixChainMultipication;
/**
 * 
 * 	Matrix Chain Multipication:
 * 	given a string or string array, we break the array from i-k and (k+1)- j.   where i=0 and j=ar.length.
 * 	we solve it recursively for i-k && (k+1)- j. we increment k 
 *  and check for max vlaue for each call
 *	 @author Saroye
 */
public class MCM {

	 // FORMAT TO SOLVE. example format of mcm. 
	int example_format(int[] ar , int i, int j){		
		// base case: 
		// 1. think of smallest valid input or 
		// 2. invalid input (use this for mcm)
		if(i>j) return 0;
		for(int k=i; k<j; k++) {
			// calculate temp answer
			// write helper function to check for each temp answer. update as requirement. return the answer. 
		}return 0;
	}
	
	/**
	 * 
	 */
	public int mcm(int[] ar, int i, int j) {
		
		
		
		return 0;
	}


	public static void main(String[] args) {
		MCM m = new MCM();
	}

}
