package Interview;

import java.util.Arrays;


public class box_janitor {

	public int subsetCount(double[] arr, double sum, int n) {
		Arrays.sort(arr);
		System.out.println("Sorted: "+Arrays.toString(arr));
		int left = 0, count = 0, right = n-1;
		while(left <= right){
			if(left == right){
				count++;
				break;
			}
			if(arr[left] + arr[right] <= sum){
				left++;
				right--;
				count++;
			}
			else{
				right--;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		box_janitor s = new box_janitor();
		double [] ar =  {1.01,1.01,3.0,2.7,1.99,2.3,1.7};
		double sum=3;
		System.out.println("Array:  "+Arrays.toString(ar));
		System.out.println("Count of subsets: "+s.subsetCount(ar, sum, ar.length));
	}


}
