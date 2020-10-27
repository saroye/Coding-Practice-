package arrays;

import java.util.Arrays;

/**
 * find the element closest floor and ceil of an given element in a sorted array
 * even if the given element is given or not.
 * 
 * Approach: used BS to find the nearest element less than/greater than the given element.
 * @author Saroye
 */
public class floorCeil {
	
	public int floor(int[]ar, int n) {
		
		int start=0, end=ar.length-1, floor=-1;
		System.out.println(Arrays.toString(ar));
		
		while(start<=end) {
			
			int mid= start+ (end-start)/2;
			if(ar[mid]==n){
				floor=ar[mid];
				return floor;
			}
			else if(ar[mid]>=n){
				end=mid-1;
			}
			else {
				floor=ar[mid];
				start=mid+1;
			}
		}
		return floor;
	}
	
	public int ceil(int[]ar, int n) {
		
		System.out.println(Arrays.toString(ar));
		
		int start=0,end=ar.length-1,ceil=-1;
		while(start<=end){
			
			int mid=start+(end-start)/2;
			if(ar[mid]==n){
				ceil=ar[mid];
				return ceil;
			}
			else if(ar[mid]<n){
				start=mid+1;
			}
			else {
				ceil=ar[mid];
				end=mid-1;
			}
			
		}
		return ceil;
	}
	
	public static void main(String []args) {
		floorCeil c = new floorCeil();
		int[] ar = new int[] {1,2,3,4,5,12,18}; 
		System.out.println(c.floor(ar,7));
		System.out.println(c.ceil(ar,6));
		
		
	}

}
