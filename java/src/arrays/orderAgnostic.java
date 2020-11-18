package arrays;

/**
 * an sorted array is given, you dont know it is decending or ascending.
 * Find the nature of sorted array and find the node's position
 * @author Saroye
 */
public class orderAgnostic {
	
	public int bs(int[] ar, int n) {
		
		if(ar.length<1) return -1;
			
		else if (ar.length==1) return ar[0];
		
		else {
			if(ar[0]>ar[1]) {
				int start=0, end=ar.length-1;
				while(start<=end) {
					int mid=start+ (end-start)/2;
					if(ar[mid]==n){
						System.out.println("The position of: "+ n +" is: "+ mid);
						return mid;
					}
					else if(ar[mid]>=n) {
						start=mid+1;
					}
					else {
						end=mid-1;
					}
				}
			}
			else {
				int start=0, end=ar.length-1;
				while(start<=end) {
					
					int mid=start+ (end-start)/2;
					if(ar[mid]==n){
						System.out.println("The position of: "+ n +" is: "+ mid);
						return mid;
					}
					else if(ar[mid]>=n) {
						end=mid+1;
					}
					else {
						start=mid-1;
					}
				}
			}
		}
		
		return -1;
	}
	
	public static void main(String [] args) {
		
		orderAgnostic oa = new orderAgnostic();
		oa.bs(new int[] {11,10,9,8,7,5,3,1}, 9);
	}

}
