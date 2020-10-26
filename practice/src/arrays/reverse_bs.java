package arrays;

import java.util.Arrays;

public class reverse_bs {
	
	public int rbs(int[] ar, int n ) {
		System.out.println(Arrays.toString(ar));
		int start=0, end=ar.length-1;
		
		while(start<=end){
			int mid=start+ (end-start)/2;
			if(ar[mid]==n) {
				System.out.println("The position of: "+ n +" is: "+ mid);
				return mid;
			}
			else if( ar[mid]>=n){
				start=mid-1;
			}
			else {
				end=mid+1;
			}
		}	
		return -1;
	}
	
	
	public static void main(String [] args) {
		
		reverse_bs rbs = new reverse_bs();
		rbs.rbs(new int[] {11,10,9,8,7,5,3,1}, 9);
		
		
	}

}
