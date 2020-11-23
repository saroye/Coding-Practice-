package CommonSubsequence;

import java.util.Arrays;

/**
 * given 2 strings
 * longest common subsequence 
 * without caring whether it is continous or not.
 * 
 * @author Saroye
 *
 */
public class longestCommonSubsequence {
	public int LCS(String s1, String s2, int n,int m) {

		if(n==0 || m==0) {
			return 0;
		}
		if(s1.charAt(n-1)==s2.charAt(m-1)) {
			return 1+LCS(s1,s2,n-1,m-1);
		}
		else {
			return Math.max(LCS(s1,s2,n,m-1), LCS(s1,s2,n-1,m));
		}
	}

	public int LCS_td(String s1, String s2, int n, int m) {
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
				
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
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
		return t[n][m];
	}


	public static void main(String[] args) {
		longestCommonSubsequence l = new longestCommonSubsequence();
		String s1="abcgerqh";
		String s2="abdxcgerqq";
		System.out.println("String1: "+s1);
		System.out.println("String2: "+s2);
		System.out.println("Recursive Longest common subsequence: "+l.LCS(s1,s2, s1.length(),s2.length()));
		System.out.println("Iterative common subsequence: 	      "+l.LCS_td(s1, s2,s1.length(),s2.length()));

	}

}
