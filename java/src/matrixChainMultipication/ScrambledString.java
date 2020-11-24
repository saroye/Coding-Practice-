package matrixChainMultipication;


/**
 * constrans: 
 * 1. make a binary tree. 
 * 2. no node should have empty child (no null values).
 *
 *	given two strings. 
 *  swap the non leaf nodes and send back to parent node
 *  to check if the resultant string is scrambled string.
 * @author Saroye
 *
 *
 */
public class ScrambledString {

	public boolean scrambledstring(String a,String b) {
		if( (a.length()!=b.length()) || ( a.length()<=1 || b.length() <=1 ) ) {
			return false;
		}
		if( (a.length()==0 && b.length()==0) || a.compareTo(b)==0 ) {
			return true;
		}
		int n =a.length()-1;
		boolean flag=false;
		for(int i=1; i<=n; i++) {
			if(
					// case: 1
					(scrambledstring(a.substring(0, i), b.substring(n-i, i)) == true
					&&
					scrambledstring(a.substring(i,n-i), b.substring(0,n-i)) ==true)
			    ||
					// case: 2
					(scrambledstring(a.substring(0, i), b.substring(0, i)) ==true  
					&& 
					scrambledstring(a.substring(i,n-i), b.substring(i,n-i))==true)) {
				return true;
			}
		}

		return flag;
	}


	public static void main(String[] arg) {
		ScrambledString s = new ScrambledString();
		String a="great";
		String b="etagr";
		System.out.println("String A: "+a);
		System.out.println("String B: "+b);
		System.out.println("Is it Scrabmled: "+s.scrambledstring(a, b));

	}
}
