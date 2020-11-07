package arrays;

import java.util.ArrayList;

public class kadanesAlgo {
	
	public int[] contiguousAr(int[] ar) {
		int[] ans= new int[1];
		ArrayList<Integer> temp1 = new ArrayList<Integer>();
		ArrayList<Integer> current = new ArrayList<Integer>();
		int sum=0, cur_sum=0;
		
		for(int i=0; i<ar.length; i++) {
			cur_sum=cur_sum+ar[i];
			if(cur_sum>sum) {
				
			}
			
		}
			
		
		return ans;
	}
	
	public static void main(String[] args) {
		kadanesAlgo k = new kadanesAlgo();
	}

}
