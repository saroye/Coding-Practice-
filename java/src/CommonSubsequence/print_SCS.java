package CommonSubsequence;

import java.util.Arrays;

public class print_SCS {

	public String PrintSuperSequence(String a, String b, int n, int m) {

		int[][] t =new int[n+1][m+1];
		String scs="";
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
		int i=n, j=m;
		while(i>0 && j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				scs=scs+a.charAt(i-1);
				i--;
				j--;
			}
			else 
			{
				if (t[i-1][j]< t[i][j-1]){
					scs=scs+b.charAt(j-1);
					j--;
				}
				else 
				{
					scs=scs+a.charAt(i-1);
					i--;
				}
			}
		}
		while(i>0) {
			scs=scs+a.charAt(i-1);
		}
		while(j>0) {
			scs=scs+b.charAt(j-1);
		}
		String s="";
		for(i=scs.length()-1; i>=0; i--) {
			s=s+scs.charAt(i);
		}
		System.out.println("Shortest Common Sequence: "+s);
		return s;
	}



	public static void main(String[] args) {
		print_SCS p = new print_SCS();
		String a="abcgerqh";
		String b="abdxcgrq";
		System.out.println("String1: "+a);
		System.out.println("String2: "+b);
		System.out.println(p.PrintSuperSequence(a, b, a.length(), b.length()));

	}

}
