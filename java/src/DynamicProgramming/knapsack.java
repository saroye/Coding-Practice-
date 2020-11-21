package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Saroye
 * 
 *  example problem to get familiar with the DP layout.
 * 	given an weight and value  array.
 *  return the max profit
 *
 */
public class knapsack {

	public int knapsack(int[] wt,int[] val, int price, int n) {

		ArrayList<Integer> weight = new ArrayList<Integer>();
		ArrayList<Integer> value= new ArrayList<Integer>();

		if(n==0 || price==0){
			return 0;
		}
		if(wt[n-1] <= price){
			return Math.max( 
					(val[n-1] +knapsack(wt,val,price-wt[n-1], n-1) ), 
					knapsack(wt,val,price,n-1) );
		}
		else if(wt[n-1]> price) {
			return knapsack(wt,val,price,n-1);
		}
		return -1;
	}
	
	public int knapsackIterative(int[] wt,int[] val, int price, int n) {
		int[][] t=new int[n+1][price+1];
		for(int i=0; i<=n; i++) {
			for(int j=0; j<=price; j++) {
				if(i==0 || j==0) {
					t[i][j]=0;
				}
				else if(wt[i-1] <=j) {
					t[i][j]=max
							(
								val[i-1] + t[i-1][j-wt[i-1]],
								t[i-1][j]
							);
				}
				else {
					t[i][j]=t[i-1][j];
				}
			}
		}
		System.out.println("_____________________________________________");
		for(int i=0; i<t.length; i++) {
			System.out.println(Arrays.toString(t[i]));
		}
		System.out.println("_____________________________________________");
		return t[n][price];
	}


	int max(int a, int b)  
    {  
          return (a > b) ? a : b;  
    } 
	
	public static void main(String[] args) {

		knapsack k = new knapsack();
		int [] wt = new int [] {1,3,4,5};
		int [] val = new int [] {1,2,4,5};
		int val1[] = new int[] { 60, 100, 120 }; 
		int wt1[] = new int[] { 10, 20, 30 }; 
		int price = 7; 
		System.out.println("Weight:    "+Arrays.toString(wt));
		System.out.println("Value:     "+Arrays.toString(val)); //knapsackItr
		System.out.println("Price:     "+price);
		System.out.println("Recurisve: "+k.knapsack(wt, val, price, 4));
		System.out.println("Iterative: "+k.knapsackIterative(wt, val, price,4));
	}

}
