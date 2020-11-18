package Interview;

import java.util.Arrays;

public class guide {
	
	
	public String consecutive(String str) {
		int count=1;
		char s =str.charAt(0);
		String str1=""+s;
		if(str.length()<=1){
			return str;
		}
		else {
			for(int i =1; i<str.length(); i++) {
				if(str.charAt(i) ==s) {
					count++;
					if(!(count>=3)){
						str1=str1+str.charAt(i);
					}
				}
				else {
					str1=str1+str.charAt(i);
					count=1;
					s=str.charAt(i);
				}	
			}
		}
		return str1;
	}
	
	public int s1(int n) {
		int ans=n+1;
		int check_sum=0, check_sum_n=0;
		boolean check=true;
		while(check) {
			if( ans<10){
				if((ans-1)==n) {
					return ans-1;
				}
				else {
					return -1;
				}
			}
			else {
				check_sum=this.helper(ans);
				check_sum_n=this.helper(n);			
				if(check_sum_n*2 == check_sum ) {
					return ans;
				}
				else {
					ans++;
					check_sum=0;
					check_sum_n=0;
				}
			}
		}
		return -1;
	}
	
	public int helper(int n) {
		String ss = Integer.toString(n);
		int check_sum=0;
		String[]  s = ss.split("");
		int[] ar = new int[s.length];
		for(int i=0; i<ar.length; i++){
			ar[i] = Integer.parseInt(s[i]);
			check_sum=check_sum+ar[i];
		}
		return check_sum;
	}
	
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
	
	public static void main(String[] args) {
		
		guide g = new guide();
		System.out.println(g.s1(14));
		System.out.println(g.solution(new int []{1, 1,3, 3}, 2));	
	}

}

