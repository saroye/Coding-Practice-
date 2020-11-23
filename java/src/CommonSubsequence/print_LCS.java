package CommonSubsequence;

import java.util.Arrays;
/**
 * 
 * given two string, print the longest subsequence in both of the strings
 * @author Saroye
 *
 */
public class print_LCS {

	public String print_LCS(String a, String b, int n, int m) {
		int[][] t=new int[n+1][m+1];
		String lcs="";
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
		int i=n, j=m;
		while(i>0 && j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				lcs=lcs+a.charAt(i-1);
				i--;
				j--;
			}
			else if (t[i-1][j]< t[i][j-1]){
				j--;
			}
			else {
				i--;
			}
		}
		//System.out.println("before: "+lcs);
		String s="";
		i=0;
		for(i=lcs.length()-1; i>=0; i--) {
			s=s+lcs.charAt(i);
		}
		//System.out.println("After: "+s);
		return s;
	}
	
	public static void main(String[] args) {
		
		print_LCS s = new print_LCS();
		String s1="abcgerqh";
		String s2="abdxcgrqq";
		System.out.println("String1: "+s1);
		System.out.println("String2: "+s2);
		System.out.println("Longest Common String: "+s.print_LCS(s1,s2,s1.length(),s2.length()));
	}
}
