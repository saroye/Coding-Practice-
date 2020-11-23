package CommonSubsequence;


/**
 * minimun number of insertion and deletion required 
 * to convert from string a to string b.
 * @author Saroye
 */
public class insertionDeletion {
	
	public void  minDeletionInsertion(String a, String b, int n, int m) {
		
		int[][] t =new int[n+1][m+1];
		int del=0, insert=0;
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
		del=n-t[n][m];
		insert=m-t[n][m];
		System.out.println("Deletions: "+del);
		System.out.println("Inserts:   "+insert);
	}
	
	
	public static void main(String[] args) {
		
		insertionDeletion i = new insertionDeletion();
		String a="heap";
		String b="pea";
		int n=a.length(), m=b.length();
		i.minDeletionInsertion(a, b, n, m);
	}

}
