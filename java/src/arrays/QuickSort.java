package arrays;

import java.util.Arrays;

public class QuickSort {

	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high];  
		int i = (low-1);
		for (int j=low; j<high; j++) 
		{	 
			if (arr[j] < pivot) { 
				i++;  
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 
		return i+1; 
	} 


	void sort(int arr[], int low, int high) { 
		if (low < high) { 
			int pi = partition(arr, low, high); 

			sort(arr, low, pi-1); 
			sort(arr, pi+1, high); 
		} 
	} 

	public static void main(String args[]) { 
		
		int[] arr= {10, 7, 8, 9, 1, 5,10,4,20,14,25,12,18,16,30,22,55,66,44,33}; 
		int n = arr.length; 
		QuickSort ob = new QuickSort(); 
		ob.sort(arr, 0, n-1); 

		System.out.println("Sorted array: "+ Arrays.toString(arr)); 
	} 

}