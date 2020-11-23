package CommonSubsequence;

import java.util.Arrays;
/**
 * given a string find the longest palindrome sequence in the string.
 * @author Saroye
 *
 */
public class LongestPalindromSubString {
	public int LongestCommonSubStringPalindrome(String a, int n) {
		int max=Integer.MIN_VALUE;
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
		LongestPalindromSubString lpss = new LongestPalindromSubString();

		String a="adjtbrxrbtkhfgoa";
		System.out.println("String3: "+a);
		System.out.println(lpss.LongestCommonSubStringPalindrome(a, a.length()));
		
	}
}
