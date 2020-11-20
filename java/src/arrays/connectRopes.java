package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 
 * return
 * @author Saroye
 *
 */
public class connectRopes {


	public int minCost(int[] ar) {

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int cost=0;
		int elt1=0, elt2=0;
		for(int i=0; i<ar.length; i++) {
			minHeap.add(ar[i]);
		}
		while(minHeap.size()>=2) {

			elt1=minHeap.poll();
			elt2=minHeap.poll();
			cost=cost+elt1+elt2;
			minHeap.add(elt1+elt2);
		}

		return cost;
	}

	public int maxCost(int[] ar) {

		PriorityQueue<Integer> maxnHeap = new PriorityQueue<>((a,b) -> b - a); 
		int cost=0;
		int elt1=0, elt2=0;
		
		for(int i=0; i<ar.length; i++) {
			maxnHeap.add(ar[i]);
		}
		while(maxnHeap.size()>=2) {
			elt1=maxnHeap.poll();
			elt2=maxnHeap.poll();
			cost=cost+elt1+elt2;
			maxnHeap.add(elt1+elt2);
		}
		return cost;
	}

	public static void main(String[] args) {

		connectRopes c = new connectRopes();
		int[] ar= new int[] {1,2,3,4,5};
		System.out.println("Min Cost: "+c.minCost(ar));
		System.out.println("Max Cost: "+c.maxCost(ar));
		Arrays.sort(ar);
		System.out.println("sorted: "+Arrays.toString(ar));


	}

}
