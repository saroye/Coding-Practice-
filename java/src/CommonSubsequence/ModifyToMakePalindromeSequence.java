package CommonSubsequence;


/**
 * given a string return minimun number of deletion and insertions
 * to make a given sequence palindrome
 * @author Saroye
 *
 */
public class ModifyToMakePalindromeSequence {
	
	public void  DeletionInsertion(String a, int n) {
		int[][] t =new int[n+1][n+1];
		String b="";
		int del=0, insert=0;
		for(int i=a.length()-1; i>=0; i--) {
			b=b+a.charAt(i);
		}
		System.out.println("String A: "+a);
		System.out.println("String B: "+b);
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
		del=a.length()-t[n][n];
		insert=a.length()-t[n][n];
		System.out.println("Deletions  Necessary: "+del);
		System.out.println("Insertions Necessary: "+insert);
	}
	
	
	
	
	public static void main(String[] args) {
		ModifyToMakePalindromeSequence m = new ModifyToMakePalindromeSequence();
		String a="agwqba";
		String b="aebcbda";
		m.DeletionInsertion(a,a.length());
	}
}
