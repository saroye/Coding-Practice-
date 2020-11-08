package stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

/**
 *  * @author Saroye
 *
 * 	nearest greater to the right (Next largest element) 
 * 	and their 4 variations (greater/smaller on the left and right side)
 * 	Given: int array.	
 */
public class NextLargestElement {
	
	public int[] nearestGreatertoRight(int[] ar) {
		int[] ans= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();
		
		for(int i=ar.length-1; i>=0; i--) {
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else if(s.size() > 0 && s.peek() > ar[i]) {
				ans[i]=s.peek();
			}
			else if(s.size() > 0 && s.peek() < ar[i]) {
				while(s.size() > 0 && s.peek() <= ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					ans[i]=-1;
				}
				else {
					ans[i]=s.peek();
				}
			}
			s.push(ar[i]);
		}
		System.out.println("Nearest Largest to right: "+Arrays.toString(ans));
		return ans;
	}
	
	public int[] nearestGreatertoLeft(int[] ar) {
		int[] ans= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i =0; i<ar.length; i++) {
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else if(s.size()>0 && s.peek()>ar[i]) {
				ans[i]=s.peek();
			}
			else if(s.size()>0 && s.peek()<=ar[i]) {
				while(s.size()>0 && s.peek()<=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					ans[i]=-1;
				}
				else {
					ans[i]=s.peek();
				}
			}
			s.push(ar[i]);
		}
		System.out.println("Nearest Largest to left:  "+Arrays.toString(ans));
		return ans;
	}
	
	public int[] nearestSmallerToLeft(int[] ar) {
		int[] ans= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i =0; i<ar.length; i++) {
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else if(s.size()>0 && s.peek()<ar[i]) {
				ans[i]=s.peek();
			}
			else if(s.size()>0 && s.peek()>=ar[i]) {
				while(s.size()>0 && s.peek()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					ans[i]=-1;
				}
				else {
					ans[i]=s.peek();
				}
			}
			s.push(ar[i]);
		}
		System.out.println("Nearest smaller to left:  "+Arrays.toString(ans));
		return ans;
	}
	
	
	
	public int[] nearestSmallerToRight(int[] ar) {
		int[] ans= new int[ar.length];
		Stack<Integer> s = new Stack<Integer>();
		for(int i= ar.length-1; i>=0; i--) {
			if(s.isEmpty()) {
				ans[i]=-1;
			}
			else if(s.size()>0 && s.peek()<ar[i]) {
				ans[i]=s.peek();
			}
			else if(s.size()>0 && s.peek()>=ar[i]) {
				while(s.size()>0 && s.peek()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					ans[i]=-1;
				}
				else {
					ans[i]=s.peek();
				}
			}
			s.push(ar[i]);
		}
		System.out.println("Nearest smaller to Right:  "+Arrays.toString(ans));
		return ans;
	}
	
	public static void main(String[] args) {
		
		NextLargestElement g = new NextLargestElement();
		int[] ar =new int[] {4,5,2,10,8};
		System.out.println("Given array for nearest:  "+Arrays.toString(ar));
		g.nearestGreatertoRight(ar);
		g.nearestGreatertoLeft(ar);
		g.nearestSmallerToLeft(ar);
		g.nearestSmallerToRight(ar);
		
	}

}
