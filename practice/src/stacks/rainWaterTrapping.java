package stacks;

import java.util.Arrays;
import java.util.Stack;

/** 
 * @author Saroye
 *
 *	given an array. Assume they as towers to store the water.
 *	find the area where the water can be stored
 *	Find the total units of water = E water on each tower
 *
 *	Apporach: find the absolute max element on right and left 
 *	from each tower and then take the min(left, right)
 *	and subtract the current ar[i] from the min(left, right)
 */
public class rainWaterTrapping {

	public int maxWaterStored(int[] ar) {

		int[] left=this.maxLeft(ar);
		int[] right=this.maxRight(ar);
		int[] water=new int[ar.length];
		int units=0;
		System.out.println("Left:  "+Arrays.toString(left));
		System.out.println("Right: "+Arrays.toString(right));

		for(int i=0; i<ar.length; i++) {
			water[i]= Math.min(left[i], right[i]) - ar[i] ;
			units=units+ ( Math.min(left[i], right[i]) - ar[i] );	
		}
		System.out.println("Water: "+Arrays.toString(water));
		System.out.println("Max units of water Stored: "+units);
		return units;
	}

	public int[] maxLeft(int[] ar) {
		int[] left= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();

		for(int i=0; i<ar.length; i++) {
			if(s.isEmpty()) {
				left[i]=ar[i];
				s.push(ar[i]);
			}
			else if(s.size()>0 && ar[i]>s.peek()) {
				s.push(ar[i]);
				left[i]=ar[i];
			}
			else {
				left[i]=s.peek();
			}
		}
		return left;
	}

	public int[] maxRight(int[] ar) {
		int[] right= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();

		for(int i=ar.length-1; i>=0; i--) {
			if(s.isEmpty()) {
				right[i]=ar[i];
				s.push(ar[i]);
			}
			else if(s.size()>0 && ar[i]>s.peek()) {
				s.push(ar[i]);
				right[i]=ar[i];
			}
			else {
				right[i]=s.peek();
			}
		}
		return right;
	}

	public static void main(String[] args) {
		rainWaterTrapping r = new rainWaterTrapping();
		int[] ar = new int[] {3,0,0,2,0,4};
		//int[] ar = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("Array: "+Arrays.toString(ar));
		r.maxWaterStored(ar);

	}
}
