package matrixChainMultipication;

/**
 * given a string we have to partion the string so that the string left is palindrome
 * @param args
 */
public class palindromePartion {
	
	
	public int partioning(String s, int i, int j) {
		int ans=Integer.MAX_VALUE;
		if(i>=j) {
			return 0;
		}
		if(isPalindrome(s,i,j)) {
			return 0;
		}
		for(int k=i; k<=j-1; k++) {
			int temp= 1+partioning(s,i,k)+partioning(s,k+1,j);
			ans=Math.min(ans, temp);
		}
		return ans;
	}
	
	public boolean isPalindrome(String s, int i, int j) {
		int l=j;
		for(int k=i; k<=j; k++) {
			if(s.charAt(k)!=s.charAt(l)) {
				return false;
			}
			l--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		palindromePartion p = new palindromePartion();
		String a="abcbsa";
		System.out.println(p.partioning(a, 0, a.length()-1));
		
	}

}
