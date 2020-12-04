package arrays;

import java.util.*;

public class sum3 {

	public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int start=0,end=nums.length-1;
//		for(int i=0; i<nums.length; i++) {
//		}
		while(start<end) {
			int first=nums[start];
			int second=nums[start+1];
			int last=nums[end];
			if(first+second+last==0) {
				ArrayList<Integer> list_inner=new ArrayList<Integer>();
				list_inner.add(first);
				list_inner.add(second);
				list_inner.add(last);
				list.add(list_inner);
				start=start+2;
				last--;
			}
			else {
				start=start+2;
				last--;
			}
		}
		System.out.println("???");
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		sum3 s = new sum3();
		int[] ar = {-1,0,1,2,-1,-4};
		
		s.threeSum(ar);
	}

}
