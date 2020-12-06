package arrays;

import java.util.*;

public class sum3 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		int s=0,e=nums.length-1;
		if (nums.length>=3) {
			while(s<e) {
				int first=nums[s];
				int second=nums[s+1];
				int last=nums[e];
				if(first+second+last==0) {
					ArrayList<Integer> list_inner=new ArrayList<Integer>();
					list_inner.add(first);
					list_inner.add(second);
					list_inner.add(last);
					list.add(list_inner);
					s++;
					e--;
				}
				else if((first+second) <last) {
					s++;
				}
				else {
					e--;
				}
			}
		}
		else {
			return list;
		}
		
		System.out.println("------------");
		for(int i=0; i<list.size(); i++) {
			System.out.println("List "+i+": "+list.get(i));
		}
		return list;
	}

	public static void main(String[] args) {
		sum3 s = new sum3();
		int[] ar = {0,0,0,0};
		
		s.threeSum(ar);
	}

}
