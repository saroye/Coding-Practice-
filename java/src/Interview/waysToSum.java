package Interview;

import java.util.Arrays;

/**
 * 
 * automated packaging system is responsible for packing boxes.
 * box can hold upto certian weight = total.
 * calculate number of possible ways to achieve total as sum of weights.
 * of items weighing integer weights from 1 to k.
 * 
 * @author Saroye
 *
 */
public class waysToSum {

	public int ways(int total, int k) {
		
		int[][] t = new int[k+1][total+1];
//		if(n < k) {
//			return 0;
//		}
		for(int i = 0; i <= k; i++) {
			for(int j = 0; j <= Math.min(i, k); j++) {
				if (j == 0 || j == i) {
					t[i][j]=1;
				}
				else {
					t[i][j]=t[i-1][j-1]+t[i-1][j];
				}
			}
		}
		
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		
		waysToSum w = new waysToSum();
		w.ways(4,2);
		
	}
}
