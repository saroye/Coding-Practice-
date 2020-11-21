package Interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class box {

	/**
	 * Given a 2d array of zeros, there may be a rectangle (block) of 1s. 
	 * Return the top left coordinates of the rectangle. ie. [[0,0,1],[0,0,1],[0,0,1]] returns (2,2)
	 * 
	 * The second question was how to solve it if you had to find many rectangles.  
	 * 
	 * @param args
	 */
	static int res=100000;
	public static int efficientJanitor(List<Float> weight) {

		boolean[] visited = new boolean[weight.size()];
		dfs(weight, visited, 0.0, 1, 3.0);
		return res;
	}

	private static void dfs(List<Float> weight, boolean[] visited, double w, int tmp, double max) {
		if(tmp > res) {
			return; 	
		}
		if(isAllVisited(visited)) {
			res = Math.min(res, tmp);
			return;
		} 
		for(int i=0;i<weight.size();i++){
			if(!visited[i]) {
				visited[i] = true;
				if(w + weight.get(i) <= max)
					dfs(weight, visited, w + weight.get(i), tmp, max);
				else
					dfs(weight, visited, weight.get(i), tmp+1, max);
				visited[i] = false;
			}
		}
	}

	private static boolean isAllVisited(boolean[] visited) {
		for(boolean v : visited) {
			if(v == false) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		box i = new box();
		List<Float> w = new ArrayList<Float>();
		w.add((float) 1.01);
		w.add((float) 1.01);
		w.add((float) 1.01);
		w.add((float) 1.4);
		w.add((float) 2.4);
		System.out.println(i.efficientJanitor(w));

	}
}
