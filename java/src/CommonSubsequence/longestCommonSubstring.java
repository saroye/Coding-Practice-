package CommonSubsequence;

import java.util.Arrays;
/**
 * given 2 strings
 * longest common subsequence 
 * without caring whether it has to be continous.
 * 
 * @author Saroye
 *
 */
public class longestCommonSubstring {

	public int LCS(String a, String b, int n, int m) {
		int max=Integer.MIN_VALUE;
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
					if(max<t[i][j]) {
						max=t[i][j];
					}
				}
				else{
					t[i][j]=0;
				}
			}
		}
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return max;
	}
	
	public static void main(String[] args) {
		longestCommonSubstring l = new longestCommonSubstring();
		String s1="abcgerqh";
		String s2="abdxcgerqq";
		System.out.println("String1: "+s1);
		System.out.println("String2: "+s2);
		System.out.println("Recursive Longest common subsequence: "+l.LCS(s1,s2, s1.length(),s2.length()));
	}
}
