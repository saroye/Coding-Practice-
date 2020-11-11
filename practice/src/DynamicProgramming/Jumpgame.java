package DynamicProgramming;

import java.util.Arrays;

public class Jumpgame {
	
	
	public int max(int a, int b) {
		return (a>b)? a:b;
	}
	public int minSteps(int[] ar) {
		int ans=0;
		int lastStep=ar[ar.length-1];
		int[][] t = new int[ar.length+1][lastStep+1];		
		for(int i=0; i<t.length; i++) {
			for(int j=0; j<t[i].length; j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
				else if(ar[i-1] <=j) {
					t[i][j]=max(
							ar[i-1]+t[i-1][j-ar[i-1]],
							t[i-1][j]);
					if(t[i][j]==lastStep) {
					}
				}
				else {
					t[i][j]=t[i-1][j];
				}
				
			}
			
		}
		System.out.println("_______________");
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println("_______________");
		return t[t.length-1][t[0].length-1];
	}
	
	public static void main(String[] args) {
		
		int[] ar= new int[] {2,3,1,1,4};
		
		Jumpgame j = new Jumpgame();
		System.out.println(j.minSteps(ar));
	}

}
