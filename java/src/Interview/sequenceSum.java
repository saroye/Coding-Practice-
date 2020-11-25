package Interview;

/**
 *  given ints: i, j, and k.
 * 	a sequence sum to be of the value:
 * 	i + (i+1) + (i+2) .....+ j+ (j-1) + (j-2)+ (j-3) ....+ k
 * 	increment from i until it is == j.
 * 	then decrement from j until it equals k.
 * @author Saroye
 *
 */
public class sequenceSum {
	
	public int sSum(int i, int j, int k) {
		int inc=0;
		int dec=0;
		for(int a=i; a<j; a++) {
			inc=inc+a;
			System.out.print(inc+", ");
		}
		System.out.println();
		for(int a=j; a>=k; a--) {
			dec=dec+a;
			System.out.print(dec+", ");
		}
		System.out.println();
		int sum=inc+dec;
		System.out.println("Sequence Sum: "+sum);
		return sum;
	}
	
	public static void main(String[] args) {
		
		sequenceSum s = new sequenceSum();
		System.out.println(s.sSum(0,5,-1));
		
	}

}
