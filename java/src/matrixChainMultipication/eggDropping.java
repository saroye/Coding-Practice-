package matrixChainMultipication;


/**
 * given 2 integers.  
 * we have to minimize the number of attempts 
 * n worst case to find critical value/ threshold floor.
 * 
 * @author Saroye
 */
public class eggDropping {
	
	//if breaks: then numOfAttempts(e-1,f-1)
	// if it doesnot break numOfAttempts (e, f-k)
	public int numOfAttempts(int egg, int floor) {
		
		if(egg==1) {
			return floor;
		}
		if(floor==0 ||floor==1) {
			return floor;
		}
		int min=Integer.MAX_VALUE;
		for(int i=1; i<=floor; i++) {
			int temp=1+Math.max(numOfAttempts(egg-1,i-1), numOfAttempts(egg,floor-i));
			min=Math.min(min, temp);			
		}
		return min;
	}
	
	
	public static void main(String[] args) {
		
		eggDropping e = new eggDropping();
		System.out.println(e.numOfAttempts(3, 10));
		
	}

}
