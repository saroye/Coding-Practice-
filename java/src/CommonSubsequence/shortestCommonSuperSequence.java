package CommonSubsequence;

import java.util.Arrays;
/**
 * given two string, find the shortest length of a new string.
 * such that the new string represents the shortest sequence of including both strings.
 * 
 * @author Saroye
 *
 */
public class shortestCommonSuperSequence {
	
	public int superSequence(String a, String b, int n, int m) {

		int[][] t =new int[n+1][m+1];
		int super_sequence=0;
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
//		for (int i = 0; i < t.length; i++) {
//			System.out.println(Arrays.toString(t[i]));
//			
//		}
		
		super_sequence=(m+n)-t[n][m];
		int cc= a.length()+b.length();
		System.out.println("A+B = "+ a+b+" is of length: "+cc);
		System.out.println("String1: "+a+ "    is of length: "+a.length());
		System.out.println("String2: "+b+ "  is of length: "+b.length());
		System.out.println("Common: "+t[n][m]);
		System.out.println("shortest supersequence: "+super_sequence);
		return super_sequence;
	}
	
	public static void main(String[] args) {
		shortestCommonSuperSequence s = new shortestCommonSuperSequence();
		String s1="abcgerqh";
		String s2="abdxcgerqq";
		System.out.println("Shortest common SuperSequence: "+s.superSequence(s1,s2, s1.length(),s2.length()));
	}

}
