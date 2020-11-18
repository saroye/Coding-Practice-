package arrays;

/**
 * first occurence of an element in a sorted array.
 * last  occurence of an element in a sorted array.
 * count of occurences for an element in a sorted array.
 * @author Saroye
 */

public class occurence {

	public int first_occurence(int[] ar, int n) {

		int start=0, end=ar.length-1, first=-1;
		while(start<=end){
			int mid = start +(end-start)/2;

			if(ar[mid]==n) {
				first=mid;
				end=mid-1;
			}
			else if(ar[mid]<=n){
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return first;
	}

	public int last_occurence(int[] ar, int n) {
		int start=0, end=ar.length-1, last=-1;
		while(start<=end){
			int mid = start +(end-start)/2;

			if(ar[mid]==n) {
				last=mid;
				start=mid+1;
			}
			else if(ar[mid]<=n){
				start=mid+1;
			}
			else {
				end=mid-1;
			}
		}
		return last;
	}
	
	public int occurence_count(int [] ar, int n) {
		return (this.last_occurence(ar, n) - this.first_occurence(ar, n))+1;
	}
	
	
	public static void main(String[] args) {
		occurence o = new occurence();	
		System.out.println(o.first_occurence(new int[] {0,1,2,4,4,4,4,4,4,4,4,5,5,5,5,5,5,6,7,8,9,10}, 4));
		System.out.println(o.last_occurence(new int[] {0,1,2,4,4,4,4,4,4,4,4,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,6,7,8,9,10}, 5));
	}
}