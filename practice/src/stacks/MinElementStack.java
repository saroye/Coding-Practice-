package stacks;

import java.util.Stack;

/**
 * 
 * @author Saroye
 *	return the mininum element in the current stack
 */   
public class MinElementStack {
	int min;
	int push;
	int top;
	 
	public int min(int[] ar) {
		int min = 0;
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> min_s = new Stack<Integer>();
		
		
		for(int i=0; i<ar.length; i++) {
			s.push(ar[i]);
			if(s.isEmpty()) {
				min=ar[i];
				min_s.push(ar[i]);
			}
			else if(s.size()>0 && ar[i]<s.peek()) {
				min_s.push(ar[i]);
				min=ar[i];
			}
		}
		return min;
	}
	
	public void push() {
		
	}
	
	public void top() {
		
	}
	public static void main(String[] args) {
		
		MinElementStack m = new MinElementStack();
		int[] ar =new int[] {6,2,5,4,5,1,6};
		m.min(ar);
	}

}
