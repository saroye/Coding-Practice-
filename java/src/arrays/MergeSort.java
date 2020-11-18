package arrays;

import java.util.Arrays;

public class MergeSort {
	
	
	public void merge(int A[ ] , int start, int mid, int end) {
		
		int first = start , center= mid+1;

		int[] Arr =new int[end-start+1];
		int k=0;

		for(int i = start ;i <= end ;i++) {
		    if(first > mid)  {   
		       Arr[ k++] = A[ center++] ;
		    }

		   else if ( center > end)  { 
		       Arr[k++] = A[first++];
		   }

		   else if( A[first] < A[center])  {   
		      Arr[k++] = A[first++];
		   }
		   else {
		      Arr[k++] = A[center++]; 
		   }
		 }
		  for (int r=0 ; r< k ; r++) {
		     A[ start++] = Arr[r] ;                          
		  }
		}
	
	public void merge_sort (int A[ ] , int start , int end )
	   {
	           if(start<end) {
	           int mid = (start+end)/2;        
	           merge_sort (A,start,mid);                
	           merge_sort (A,mid+1,end);              

	          merge(A,start,mid,end );   
	   }                    
	}
	
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] ar= {10, 7, 8, 9, 1, 5,10,4,20,14,25,12,18,16,30,22,55,66,44,33}; 
		m.merge_sort(ar,0, ar.length-1);
		System.out.println(Arrays.toString(ar));
	}

}
