package arrays;

import java.util.Arrays;

public class MergeSort {


	void merge(int arr[], int start, int mid, int end) {  

		int l = mid - start + 1;  
		int r = end - mid;  

		int LeftArray[] = new int [l];  
		int RightArray[] = new int [r];  

		for (int i=0; i<l; ++i)  {
			LeftArray[i] = arr[start + i];  
		}
		for (int j=0; j<r; ++j) {
			RightArray[j] = arr[mid + 1+ j];  
		}
		
		int i = 0, j = 0;  
		int k = start;  
		while ( i<l && j<r)  {  
			if (LeftArray[i] <= RightArray[j])  {  
				arr[k] = LeftArray[i];  
				i++;  
			}  
			else {  
				arr[k] = RightArray[j];  
				j++;  
			}  
			k++;  
		}  
		while (i<l)  {  
			arr[k] = LeftArray[i];  
			i++;  
			k++;  
		}  

		while (j<r)  {  
			arr[k] = RightArray[j];  
			j++;  
			k++;  
		}  
	}  

	void sort(int arr[], int start, int end)  {
		if (start<end)  {  
			int  mid= start+ (end-start)/2;
			sort(arr, start, mid);  
			sort(arr , mid+1, end);  
			merge(arr, start, mid, end); 
			//System.out.println("Array: "+Arrays.toString(arr));
			
		}
	}

		public static void main(String[] args) {
			MergeSort m = new MergeSort();
			int[] ar= {11, 7, 8, 9, 1,5,10,2,4,20,3,14,25,6,12,18,16,15,30,17,13,22,55,66,44,19,33}; 
			System.out.println("Before: "+Arrays.toString(ar));
			m.sort(ar,0, ar.length-1);
			System.out.println("After:  "+Arrays.toString(ar));
		}

	}
