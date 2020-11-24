package CommonSubsequence;

import java.util.Arrays;

/**
 * 
 * given a string, find the subsequence for the characters those are repeating.
 * It has to be in same order. continuity does not matter.
 * @author Saroye
 *
 */
public class longestRepeatingSubSequence {
	
	
	public int repeatingSequence(String a, int n) {

		int[][] t =new int[n+1][n+1];
		String b="";
		for(int i=a.length()-1; i>=0; i--) {
			b=b+a.charAt(i);
		}
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[i].length; j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
			}
		}
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {
				
				if(a.charAt(i-1)==b.charAt(j-1) && i!=j) {
					t[i][j]=1+t[i-1][j-1];
				}
				else {
					t[i][j]=Math.max(t[i-1][j], t[i][j-1]);
				}
			}
		}
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println("String A: "+a);
		System.out.println("String B: "+b);
		return t[n][n];
	}
	
	
	
	public static void main(String[] args) {
		longestRepeatingSubSequence l = new longestRepeatingSubSequence();
		String a="aaeutevbbdd";
		System.out.println(l.repeatingSequence(a, a.length()));
	}

}
