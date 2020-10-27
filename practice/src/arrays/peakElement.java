package arrays;

/**
 * index of peak element (greater than both of its neighbor)
 *  in unsorted array using BS.
 * @author Saroye
 */
public class peakElement {
	
	
	public int idx_peak(int[] ar) {
		
		int start=0, end=ar.length-1, peak = Integer.MAX_VALUE;
		
		while(start<=end){
			
			int mid = start + (end-start)/2;
			
			if(mid>0 && mid < ar.length-1) {
				if( (ar[mid] > ar[mid+1]) && (ar[mid] > ar[mid-1]) ) {
					
					return mid;
				}
				else if( ar[mid-1]>ar[mid]){
					end=mid-1;
				}
				else {
					start=mid+1;
				}
			}
			else if(mid==0) {
				
				if(ar[0]>ar[1]) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else if(mid == (ar.length-1)) {
				
				if(ar[ar.length-1]> ar[ar.length-2]) {
					return ar.length-1;
				}
				else {
					return ar.length-2;
				}
			}
		}
		return peak;
	}
	
	public static void main(String[] args) {
		
		peakElement p = new peakElement();
		
		System.out.println(p.idx_peak(new int[] {5,10,20,15}));
			
	}

}
