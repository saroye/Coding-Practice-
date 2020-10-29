package DynamicProgramming;
/**
 * example problem to get familiar with the DP layout.
 * @author Saroye
 *
 */
public class knapsack {
	
	int knapsack(int[] wt,int[] val, int price, int n) {
		
		if(n==0 || price==0){
			return 0;
		}
		
		if(wt[n-1] <= price){
			return Math.max( (val[n-1] +knapsack(wt,val,price-wt[n-1], n-1)), knapsack(wt,val,price,n-1) );
		}
		else if(wt[n-1]> price) {
			return knapsack(wt,val,price,n-1);
			
		}
		return 0;
	}
	public static void main(String[] args) {
		
		knapsack k = new knapsack();
	}

}
