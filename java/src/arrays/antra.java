package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * given a unsorted array
 * sort then with first odd then even.
 * @author Saroye
 *
 */
public class antra {
	
	public String m1() {
		List<List<Integer>> ll = new ArrayList<List<Integer>> ();
		List<Integer> l1 = Arrays.asList(1, 4, 7,99,999,9999);
		List<Integer> l2 = Arrays.asList(2, 5, 8);
		List<Integer> l3 = Arrays.asList(3, 6, 9, 10, 11, 22, 33, 44);
		ll.add(l1);
		ll.add(l2);
		ll.add(l3);
		
		int row=0, col=0, check=0;
		int[] size= new int[ll.size()];
		boolean counter=true;
		
		while(counter) {
			if(row>=ll.size()) {
				col++;
				row=0;
			}
			else if( ll.get(row).size() > size[row]) {
				System.out.print(ll.get(row).get(col)+" ");
				size[row]++;
				row++;
			}
			else {
				row++;
				for(int i=0; i<ll.size(); i++){
					if(ll.get(i).size() == size[i]) {
						check++;
					}
				}
				if(check==ll.size()) {
					counter=false;
				}
				check=0;
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		antra a = new antra();
		a.m1();
	}

}
