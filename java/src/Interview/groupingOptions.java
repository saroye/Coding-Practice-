package Interview;

import java.util.Arrays;

public class groupingOptions {
	
	public int grouping(int n, int k) {
		

		int[][] t= new int[k+1][n+1];
		if(n < k) {
			return 0;
		}
		for(int i = 1; i <= k; i++) {
			for(int j = i; j <= n; j++) {
                if(i==j) {
                    t[i][j] = 1;
                } else {
                    t[i][j] = t[i-1][j-1] + t[i][j-i];
                }
			}
		}
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return t[k][n];
	}
	
	public static void main(String[] args) {
		groupingOptions g = new groupingOptions();
		int n = 8;
		int k=4;
		System.out.println("groups:   "+k);
		System.out.println("Count of subsets: "+g.grouping(n,k));
	}
	

}
