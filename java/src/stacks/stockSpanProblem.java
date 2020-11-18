 package stacks;

import java.util.Arrays;
import java.util.Stack;

/**  
 * @author Saroye
 *
 *   Problem: given an array. Find the
 *   consecutive smaller or equal to before it = nearest greater to left
 */
public class stockSpanProblem {

	public int[] StockSpan(int[] ar) {
		int[] ans = new int[ar.length];
		Stack<pair> s = new Stack<pair>();
		
		for(int i=0; i<ar.length; i++) {
			if(s.isEmpty()) {
				ans[i]=1;
			}
			else if(s.size()> 0 && s.peek().getElt()>ar[i]) {
				ans[i]=i-s.peek().getI();
			}
			else if(s.size()> 0 && s.peek().getElt()<=ar[i]) {
				while(s.size()>0 && s.peek().getElt() <= ar[i] ) {
					s.pop();
				}
				if(s.size()==0) {
					ans[i]=0;
				}
				else {
					ans[i]=i-s.peek().getI();
				}
			}
			s.add(new pair(i, ar[i]));
		} 
		System.out.println("Stock Span: "+Arrays.toString(ans));
		return ans;
	}

	public static void main(String[] args) {

		stockSpanProblem s = new stockSpanProblem();
		int[] ar = new int[] {100,80,40,60,90,70,50,60,75,85};
		System.out.println("Array: "+Arrays.toString(ar));
		s.StockSpan(ar);

	}
}


class pair{
	
	int i, elt;
	pair(int i, int elt){
		this.i=i;
		this.elt=elt; 
	}
	public int getI() {	return i;}
	public void setI(int i) {this.i = i;}
	public int getElt() {return elt; }
	public void setElt(int elt) {this.elt = elt;}
}
