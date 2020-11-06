package arrays;

import java.util.Arrays;

/**
 * 
 * sorted array is given find the position of the given node in array.
 * @author Saroye
 * 
 */
public class binarySeaarch {

	public boolean bs(int[] ar, int n) {
		
		int start =0, end=ar.length-1;

		while(start<=end) {
			int  mid= start+ (end-start)/2;
			if(ar[mid]==n) {
				return true;
			}
			else if(ar[mid]<=n) {
				start=mid+1;
			}
			else {
				end=mid-1;
			}

		}
		return false;
	}

	public static void main(String [] args) {
		binarySeaarch b = new binarySeaarch();

		System.out.println(b.bs(new int []{1, 1,3, 3}, 2));

	}

}
