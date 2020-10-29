package Interview;

import java.util.Arrays;

/**
 * 		unsorted array of non negative integer, 
 * 		index of continuous subarray that add upto a given number
 * 		[1,2,3,4,5], 12 => (1,3)
 * @author Saroye
 */
public class practice {
	
	public int[] m1(int [] ar, int n) {
		
		int[] result= new int[2];
		int target=ar[0];
		boolean idx=true;
		result[0]=0;
		if(target==n) return new int[] {0,0};		
		
		for(int i=1; i<ar.length; i++) {
			
			if(target<n)
			{
				target=target+ar[i];
			}
			if(target> n)
			{
				i=result[0]+1;
				idx=false;
				target=ar[i];
			}
			if(idx==false) 
			{
				result[0]=i;
				idx=true;
			}
			if(target==n)
			{
				result[1]=i;
				System.out.println(Arrays.toString(result)+ " i: "+i);
				return result;	
			}
		}
		
		
		return result;
	}
	
	public static void main(String [] args) {
		
		practice p = new practice();
		System.out.println(Arrays.toString(p.m1(new int[] {1,2,3,4,5}, 12)));
		
	}

}
