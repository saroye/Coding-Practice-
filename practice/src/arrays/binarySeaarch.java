package arrays;

import java.util.Arrays;

/**
 * 
 * sorted array is given find the position of the given node in array.
 * @author Saroye
 *
 */
public class binarySeaarch {
	
	public int bs(int[] ar, int n) {
		System.out.println(Arrays.toString(ar));
		int start =0, end=ar.length-1;
		
		while(start<=end) {
			int  mid= start+ (end-start)/2;
			if(ar[mid]==n) {
				System.out.println("The position of: "+ n +" is: "+ mid);
				return mid;
				
			}
			else if(ar[mid]<=n) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}
			
		}
		return -1;
	}
	
	public static void main(String [] args) {
		binarySeaarch b = new binarySeaarch();
		
		b.bs(new int []{1,2,3,4,5,6,7,8,9,10,11}, 8);
	}

}
