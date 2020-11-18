package arrays;

import java.util.Arrays;

/**
 * reverse the given string
 * @author Saroye
 */
public class reverse {
	
	public int[] rev(int[] ar) {

		System.out.println("Before: "+Arrays.toString(ar));
		int start=0, end=ar.length-1;
		while (start < end) {
			int temp=ar[start];
			ar[start]=ar[end];
			ar[end]=temp;
			start++;
			end--;
		}
		System.out.println("After:  "+Arrays.toString(ar));
		return ar;
		
	}
	
	public static void main(String [] args) {
		reverse r = new reverse();
		r.rev(new int []{1,2,3,4,5,6,7,8,9,10,11});
		
	}

}
