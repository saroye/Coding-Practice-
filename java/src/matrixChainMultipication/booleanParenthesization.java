package matrixChainMultipication;

/**
 *  a string can be consist true, false, and, or, xor.
 * 	let a string s= "T|F&T^F"
 * 	 we have to parenthesize the string so that it returns true.
 * @author Saroye
 *
 */
public class booleanParenthesization {
	
	public int parenthesization(String s, int i, int j, boolean isTrue) {
		int ans=0;
		if(i>j) {
			return 0;
		}
		if(i==j) {
			if(isTrue==true) {
				 if(s.charAt(i)=='T') {
					 return 1;
				 }
				 else {
					 return 0;
				 }
			}
			else {
				if( s.charAt(i)=='F') {
					return 1;
				}
				else {
					return 0;
				}
			}
		}
		for(int k=i+1; k<=j-1; k=k+2) {
			int lt=parenthesization(s,i,k-1,true);
			int lf=parenthesization(s,i,k-1,false);
			int rt=parenthesization(s,k+1,j,true);
			int rf=parenthesization(s,k+1,j,false);
			if(s.charAt(k)=='&') {
				if(isTrue==true) {

					ans=ans+lt*rt;
				}
				else {
					ans=ans+ lf*rt + lf*rf + lf*rf;
				}
			}
			else if(s.charAt(k)=='|') {
				if(isTrue==true) {
					ans=ans+ lt*rt + lt*rf+ lf*rt;
				}
				else {
					ans=ans+lf*rf;
				}
			}
			else if (s.charAt(k)=='^') {
				if(isTrue==true) {
					ans=ans+lf*rt+lt*rf;
				}
				else {
					ans=ans+lt*rt+lt*rf;
				}
			} 
		}
		return ans;
	}
	
	public static void main(String[] arg) {
		booleanParenthesization b = new booleanParenthesization();
		String s="T|F&T^F";
		System.out.println(b.parenthesization(s, 0,s.length(), true));
	}

}
