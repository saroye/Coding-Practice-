package Recursion;

import java.util.Stack;

public class kthSymbolinGrammar {

	
	public int symbol(int n, int k) {
		
		if(n==1 && k==1) {
			return 0;
		}
		int mid=(int) Math.pow(2, n-1)/2;
		if(k<=mid) {
			return symbol(n-1,k);
		}
		else {
			 if(symbol(n-1,k-mid)==1){
				 return 0;
			 }
			 else {
				 return 1;
			 }
		}
	}
	
	public static void main(String[] args) {
		kthSymbolinGrammar k = new kthSymbolinGrammar();
		System.out.println("Symbol: "+k.symbol(4,5));
	}
}
