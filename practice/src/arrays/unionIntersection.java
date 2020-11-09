package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class unionIntersection {

	public int[] union(int[] a, int[] b) {
		
		ArrayList<Integer> union = new ArrayList<Integer>();
		int[] arr=new int[union.size()];
		
		for(int i =0; i<a.length; i++) {
			
			 
		}
		return arr;

	}

	public int[] intersection() {

		int[] arr=new int[4];
		
		
		Set<Integer> a = new TreeSet<Integer>(Arrays.asList(new Integer[]{0,2,4,5,6,8,10}));
	    Set<Integer> b = new TreeSet<Integer>(Arrays.asList(new Integer[]{5,6,7,8,9,10}));

	    //union
	    Set<Integer> c = new TreeSet<Integer>(a);
	    c.addAll(b);
	    System.out.println(c);

	    //intersection
	    Set<Integer> d = new TreeSet<Integer>(a);
	    d.retainAll(b);
	    System.out.println(d);

	    //difference
	    Set<Integer> e = new TreeSet<Integer>(a);
	    e.removeAll(b);
	    System.out.println(e);

	    //reverse
	    List<Integer> list = new ArrayList<Integer>(a);
	    java.util.Collections.reverse(list);
	    System.out.println(list);

		return arr;

	}

	public static void main(String[] args) {
		
		unionIntersection ui = new unionIntersection();
		ui.intersection();
		

	}

}
