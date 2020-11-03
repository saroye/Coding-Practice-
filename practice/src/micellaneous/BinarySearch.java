package micellaneous;
import java.util.Arrays;

public class BinarySearch {

//		public boolean solution1(int[] A, int K){
	//
//			if(K>A[A.length-1]) {
//				return false;
//			}
	//
//			int count=0;
//			for(int i=1; i<K-1; i++) {
//				for(int j=0; i<A.length; i++) {
	//
//					if( i == A[j])  {
//						count++;
//					}
//				}
//			}
//			return true;
	//
//		}

		public boolean solution(int[] A, int K){


			if(K>A[A.length-1]) return false;

			for(int i=1; i<=K; i++){

				if(!bs(A, i))	return false;
			}
			return true;
		}
		
		
		public boolean bs(int[] ar, int n) {
			
			int start =0, end=ar.length-1;

			while(start<=end) {
				int  mid= start+ (end-start)/2;
				if(ar[mid]==n) {
					return true;
				}
				else if(ar[mid]<=n) {
					start=mid+1;
				}
				else {
					end=mid-1;
				}

			}
			return false;
		}

		public static void main(String [] args) {
			BinarySearch b = new BinarySearch();

			System.out.println(b.solution(new int []{1, 1,3, 3}, 2));
			System.out.println(b.bs(new int []{1, 1,3, 3}, 2));

		}

	}
