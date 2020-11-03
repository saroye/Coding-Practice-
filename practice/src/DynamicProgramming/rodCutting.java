package DynamicProgramming;
/**
 * 
 *  unbounded knapsack
 * @author Saroye
 *
 */
public class rodCutting {


	public int max(int[] price, int n ) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		for (int i = 0; i<n; i++) {
			max_val = Math.max(max_val,
					price[i] + max(price, n-i-1));
		}
		return max_val;


	}


	public static void main(String[] args) {

		rodCutting rc = new rodCutting();
		int[] price = new int [] {1,4,6,8,9,10,12,15};
		
		System.out.println(rc.max(price, 9));

	}

}
