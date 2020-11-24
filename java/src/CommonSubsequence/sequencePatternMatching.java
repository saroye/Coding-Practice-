package CommonSubsequence;

import java.util.Arrays;

/**
 * given 2 strings. check if string a is a subsequence of string b.
 * order is preserved!
 * 
 * @param args
 */
public class sequencePatternMatching {
	
	public boolean checkPattern(String a, String b, int n, int m) {
		int[][] t =new int[n+1][m+1];
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[i].length; j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
			}
		}
		for(int i=1; i<t.length; i++) {
			for(int j=1; j<t[i].length; j++) {
				
				if(a.charAt(i-1)==b.charAt(j-1)) {
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
		if(t[n][m]==a.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		sequencePatternMatching s = new sequencePatternMatching();
	}

}
