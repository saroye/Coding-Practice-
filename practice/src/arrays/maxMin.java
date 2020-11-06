package arrays;


/**
 * find the min and max in an array.
 * @author Saroye
 */
public class maxMin {

	
	public int max(int[] ar) {
		int max = Integer.MIN_VALUE;
		for(int i =0; i<ar.length; i++) {
			if(ar[i]>max) {
				max=ar[i];
			}
		}
		return max;
	}
	
	public int min(int[] ar) {
		int min = Integer.MAX_VALUE;
		for(int i =0; i<ar.length; i++) {
			if(ar[i]<min) {
				min=ar[i];
			}
		}
		return min;
	} 
	
	public static void main(String [] args) {
		
		maxMin mm = new maxMin();
		System.out.println(mm.max(new int []{21,2,3,4,5,6,7,8,9,10,11}));
		System.out.println(mm.min(new int []{1,2,3,4,5,6,7,8,9,10,11,0}));
	}
}
