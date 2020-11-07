package micellaneous;

import java.util.Arrays;

public class mock {
	/**
	 * 			[3,5,1,6,2,9,8,null,null,7,4]
	 * 			[3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
	 * @param A
	 * @return
	 */
	
	public int[][] flipAndInvertImage(int[][] A) {
		int len=A[0].length-1;
		int temp=0;
		
		/**
		 * 
		 */
		int[][] ar = new int[A.length][A[0].length];
		for( int i=0; i<A.length; i++) {
			for( int j=0; j<A[0].length/2; j++) {
				temp=A[i][len-j];
				A[i][len-j]=A[i][j];
				A[i][j]=temp;
			}
		}
		for( int i=0; i<A.length; i++) {
			for( int j=0; j<A[0].length; j++) {
				if(A[i][j]==0) {
					A[i][j]=1;
				}
				else {
					
					A[i][j]=0;
				}
			}
		}
		
		for(int i=0; i<A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
		
		return A;
	}
	
	
	public static void main(String[] args) {
		mock m = new mock();
		int[][] ar= new int[][] {{1,1,0,0,1},{1,0,1,0,0},{1,1,0,0,0}};
		System.out.println(Arrays.toString(ar[0]));
		System.out.println(Arrays.toString(ar[1]));
		System.out.println(Arrays.toString(ar[2]));
		System.out.println("*****************");
		m.flipAndInvertImage(ar);
	}

}
