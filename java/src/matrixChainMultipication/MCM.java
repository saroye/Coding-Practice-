package matrixChainMultipication;
/**
 * 
 * 	Matrix Chain Multipication (General idea):
 * 	given a string or string array, we break the array from i-k and (k+1)- j.   where i=0 and j=ar.length.
 * 	we solve it recursively for i-k && (k+1)- j. we increment k 
 *  and check vlaue for each call and return min value
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
	 * matrix size = ar.length()-1;
	 * how to take i, j and k
	 * 2 options: 
	 * 		k= i, then k= j-1; this will go from i to k and k+1 to j
	 * 		k= i+1,  then k=j; this will go from i to k-1 and j to j.
	 * 
	 */
	public int mcm(int[] ar, int i, int j) {
		
		if(i>=j) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			
			int temp=mcm(ar,i,k)+ mcm(ar,k+1,j)+ (ar[i-1]*ar[k]*ar[j]);
			System.out.println("temp: "+temp);
			if(temp<min) {
				min=temp;
			}
			
		}
		return min;
	}

	
public int mcm_memoization(int[] ar, int i, int j) {
		
		if(i>=j) {
			return 0;
		}
		int min=Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			
			int temp=mcm(ar,i,k)+ mcm(ar,k+1,j)+ (ar[i-1]*ar[k]*ar[j]);
			if(temp<min) {
				min=temp;
			}
			
		}
		return min;
	}

	public static void main(String[] args) {
		MCM m = new MCM();
		int[] ar = {40,20,30,10,30};
		System.out.println(m.mcm(ar, 1, ar.length-1));
	}

}
