package Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 
 * using heap: using the kth value. 
 * make a stack and pop the value greater than k.
 * 
 * @author Saroye
 */

public class kthElement {
	
	public int kLargesrValue(int[] ar, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		
		for(int i=0; i<ar.length; i++) {
			minHeap.add(ar[i]);
			if(minHeap.size()>k) {
				minHeap.poll();
			}
		}
		return minHeap.peek();
	}
	
	public int kSmallestValue(int[] ar, int k) {
		
		PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder()); 
		//PriorityQueue<Integer> maxHeap =new PriorityQueue<>((a,b) -> b - a); 
		for(int i=0; i<ar.length; i++) {
			maxHeap.add(ar[i]);
			if(maxHeap.size() >k) {
				maxHeap.poll();
			}
		}
		return maxHeap.peek();
	}
	
	public int kClosetNumber(int[] ar, int k) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		kthElement k = new kthElement();
		int[] ar= new int[] {7,10,4,3,20,15};
		System.out.println("Kth max: "+k.kLargesrValue(ar,3));
		System.out.println("Kth min: "+k.kSmallestValue(ar,3));
		Arrays.sort(ar);
		System.out.println("sorted: "+ Arrays.toString(ar));
	}
	
	
	

}
