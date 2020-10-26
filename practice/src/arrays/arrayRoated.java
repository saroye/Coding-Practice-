package arrays;

/**
 * 
 * a sorted array is rotated.
 * find how many times the array is rotated.
 * 
 * @author Saroye
 *
 */
public class arrayRoated {
	
	public int rotated(int[] ar) {
		
		int start=0, n=ar.length-1, end=ar.length-1;
		
		while(start<=end){
			
			int mid=start+ (end-start)/2;
			int next= (mid+1)%n;
			int prev=(mid-1+n)%n;
			
			if( (ar[mid]<=ar[next]) && (ar[mid] <=ar[prev]) ) {
				return mid;
			}
			else if(ar[start] <= ar[mid]) {
				start=mid+1;
			}
			else if (ar[mid]<= ar[end]){
				end=mid-1;
			}
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		
		arrayRoated ar = new arrayRoated();
		System.out.println(ar.rotated(new int[] {5,6,8,11,12,15,18,2,3}));
		
		
	}
	
	

}
