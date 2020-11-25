package Interview;
import java.util.*;

public class box_prefix {


	/**
	 * given a string split string into 2 substrings at every possible point. 
	 * rightmost substring is suffix. 
	 * beginning of string is prefix.
	 * determine the lengths of common prefix between each suffix and original string. 
	 * sum and return length of common prefies. return an array where each element i is sum of string i
	 */

	public List<Integer> commonPrefix(List<String> input) {
		ArrayList<Integer> prefixSum=  new ArrayList<Integer>();
		for(int i=0; i<input.size(); i++) {
			prefixSum.add(input_k(input.get(i)));
		}
		return prefixSum;
	}
	
	public int input_k(String input) {
		int[] common = new int[input.length()];
		int sum=0;
		common[0]=input.length();
		String[] preffix =new String[input.length()];
		String[] suffix =new String[input.length()];
		for(int i=0; i<input.length(); i++) {
			preffix[i]=input.substring(0, i);
			suffix[i]=input.substring(i, input.length());
		}
		int m=1;
		while(suffix[m].length()>=preffix[m].length()) {
			if(preffix[m].substring(0, m).compareTo(suffix[m].substring(0, m))==0) {
				common[m]=preffix[m].length();
				if(m<suffix[m].length()) {
					m++;
				}
				else {
					break;
				}
			}
			else {
				common[m]=0;
				if(m<suffix[m].length()) {
					m++;
				}
				else {
					break;
				}
			}
		}
		for(int i=0; i<common.length; i++) {
			sum=sum+common[i];
		}
		return sum;
	}

	public static void main(String[] args) {
		box_prefix p =new box_prefix();
		ArrayList<String> prefixSum=  new ArrayList<String>();
		prefixSum.add("abcabcd");
		prefixSum.add("aa");
		prefixSum.add("aaaaaaa");
		prefixSum.add("abbbaabbbaga");
		System.out.println(p.commonPrefix(prefixSum));
	}
}
