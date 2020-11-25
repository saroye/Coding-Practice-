package Interview;

import java.util.ArrayList;
import java.util.List;

public class cuttingMetal {
	public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
		int pieces=0;
		int total_cuts=0;
		for(int i=0; i<lengths.size(); i++) {
//			if() {
//				
//			}
		}
		return salePrice;
	}
//	
//	public int profit(int length) {
//		
//	}
	
	public static void main(String[] args) {
		box_cutting c = new box_cutting();
		List<Integer> w = new ArrayList<Integer>();
		w.add(30);
		w.add(15);
		w.add(10);
		w.add(6);
		w.add(5);
		w.add(3);
		System.out.println(c.maxProfit(1,10,w));
		
		
	}
}
