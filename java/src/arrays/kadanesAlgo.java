package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kadanesAlgo {

	public int maxSubArraySum(int[] a) {

		int max_cur = Integer.MIN_VALUE, max = 0; 
		//ArrayList<Integer> subset= new ArrayList<Integer>();
		
		for (int i = 0; i < a.length; i++) 
		{ 
			max = max + a[i]; 
			//subset.add(a[i]);
			if (max_cur < max) {
				max_cur = max; 
			}
			if (max < 0) {
				//subset.clear();
				max = 0; 
			}
		} 
//		int[] ar= new int[subset.size()];
//		for(int i=0; i<subset.size(); i++) {
//			ar[i]=subset.get(i);
//		}
//		System.out.println(Arrays.toString(ar));
		return max_cur; 
	}

	public static void main(String[] args) {
		kadanesAlgo k = new kadanesAlgo();
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		System.out.println("Array: "+Arrays.toString(a));
		System.out.println("Maximum contiguous sum is " + k.maxSubArraySum(a)); 
	}

}
