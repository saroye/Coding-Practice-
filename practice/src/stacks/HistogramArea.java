package stacks;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * @author Saroye
 *	we have different building of different heights of width 1. basically an array
 *	we need to find a rectangle with max area. for the area of different heights.	
 *
 */
public class HistogramArea {


	public int maxAreaOfHistogram(int[] ar) {
		int[] left=leftSide(ar);
		int[] right=rightSide(ar);
		int[] area=new int[ar.length];
		System.out.println("Left:   "+ Arrays.toString(left));
		System.out.println("Right:  "+ Arrays.toString(right));
		int maxArea=0;
		int[] width =new int[ar.length];
		for(int i =0; i<width.length; i++){
			width[i]=(right[i]-left[i])-1;
		}
		System.out.println("Width:  "+ Arrays.toString(width));
		for(int i=0; i<ar.length; i++) {
			area[i]=ar[i]*((right[i]-left[i])-1);
			int cur_area=ar[i]*width[i];
			if(maxArea<=cur_area) {
				maxArea=cur_area;
			}
		}
		System.out.println("Area:   "+ Arrays.toString(area));
		System.out.println("Max Area is: " +maxArea);
		return maxArea;
	}
	public int[] leftSide(int[] ar) { 
		int[] l=new int[ar.length]; 
		Stack<pair> s=new Stack<pair>();
		
		for(int i=0; i<ar.length; i++) {
			if(s.isEmpty()) {
				l[i]=-1;
			}
			else if(s.size()>0 && s.peek().getElt()<ar[i]) {
				l[i]=s.peek().getI();
			}
			else if(s.size()>0 && s.peek().getElt()>=ar[i]) {
				while(s.size()>0 && s.peek().getElt()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					l[i]=-1;
				}
				else {
					l[i]=s.peek().getI();
				}
			}
			s.push(new pair(i, ar[i]));

		}
		return l;
	}

	public int[] rightSide(int[] ar) {
		int[] r=new int[ar.length]; 
		Stack<pair> s=new Stack<pair>();
		
		for(int i=ar.length-1; i>=0; i--) {
			if(s.isEmpty()) {
				r[i]=ar.length;
			}
			else if(s.size()>0 && s.peek().getElt()<ar[i]) {
				r[i]=s.peek().getI();
			}
			else if(s.size()>0 && s.peek().getElt()>=ar[i]) {
				while(s.size()>0 && s.peek().getElt()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					r[i]=ar.length;
				}
				else {
					r[i]=s.peek().getI();
				}
			}
			s.push(new pair(i, ar[i]));

		}
		return r;
	}

	public static void main(String[] args) {
		HistogramArea h = new HistogramArea();
		int[] ar = new int[] {6,2,5,4,5,1,6};
		System.out.println("Array:  "+Arrays.toString(ar));
		h.maxAreaOfHistogram(ar);
	}
}
