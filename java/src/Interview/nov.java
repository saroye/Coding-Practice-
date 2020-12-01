package Interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class nov {

	Integer[][][][] dp;
	Set<Integer> add = Set.of(1, 9, 99);
	public int compression(String s, int k) {
		int len = s.length();
		dp = new Integer[len + 1][27][len + 1][k + 1];
		return dfs(s, 0, (char) ('a' + 26), 0, k);
	}

	private int dfs(String s, int idx, char p, int cnt, int k) {
		if (k < 0) return Integer.MAX_VALUE;
		if (idx >= s.length()) return 0;
		if (dp[idx][p - 'a'][cnt][k] != null) return dp[idx][p - 'a'][cnt][k];
		int res = 0;
		if (s.charAt(idx) == p) res = dfs(s, idx + 1, p, cnt + 1, k) + (add.contains(cnt) ? 1 : 0);
		else res = Math.min(dfs(s, idx + 1, s.charAt(idx), 1, k) + 1, dfs(s, idx + 1, p, cnt, k - 1));
		dp[idx][p - 'a'][cnt][k] = res;
		return res;
	}

	public static char slowestKey(List<List<Integer>> keyTimes) {
		// Write your code here
		//keyTimes = [[chr(k[0] + 97), k[1]] for k in keyTimes]                    
		int slowest=Integer.MIN_VALUE;
		for(int i=1; i<keyTimes.size(); i++) {
			if(keyTimes.get(i).size()>1) {
				int time= keyTimes.get(i).get(1)-keyTimes.get(i-1).get(1);
				if(time>slowest) {
					slowest=keyTimes.get(i).get(0);
				}
			}

		}
		return (char) ('a'+slowest);
	}

	public static String compressWord(String word, int k) {
		// Write your code here
		String str="";
		int s=0,count=1;
		boolean flag=false;
		for(int j=0; j<word.length()-1; j++) {
			if(word.charAt(j)==word.charAt(j+1)) {
				if(flag==false) {
					s=j;
					flag=true;
				}
				count++;
				System.out.println("S: "+s+ " j: "+j);
				if(count==k) {
					word=word.substring(0, s)+ word.substring(j+2, word.length());
					s=0;
					count=1;
					break;
				}
			}
			else {
				flag=false;
				s=0;
				count=1;
			}
		}
		return word;
	}







	static int[] dx=new int[]{1,-1,0,0};
	static int[] dy=new int[]{0,0,-1,1};
	public static int findMinDistance(int w, int h, int n) {

		int[][] grid=new int[w][h];
		for(int i=0;i<w;i++){
			Arrays.fill(grid[i],-1);
		}
		return solve(n,w,h,0,0,grid);
	}
	static int bfs(int w,int h,int grid[][]){
		int[][] dist=new int[w][h];
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				dist[i][j]=grid[i][j];
			}
		}
		int maxDist=0;
		Queue<Location> q=new LinkedList<>();
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				if(dist[i][j]==0){
					q.add(new Location(i,j));
				}
			}
		}
		while(!q.isEmpty()){
			int x=q.peek().first;
			int y=q.peek().second;
			maxDist=Math.max(maxDist,dist[x][y]);
			q.poll();
			for(int d=0;d<4;d++){
				int newX=x+dx[d];
				int newY=y+dy[d];
				if(newX>=w||newY>=h||newX<0||newY<0)
					continue;
				if(dist[newX][newY]==-1){
					dist[newX][newY]=dist[x][y]+1;
					q.add(new Location(newX,newY));
				}
			}
		}
		return maxDist;
	}
	static int solve(int left,int w,int h,int row,int col,int[][]grid){
		if(left==0)
			return bfs(w,h,grid);
		int r=row,c=col;
		if(col>=h){
			r+=col/h;
			c=col%h;
		}
		int minDist=Integer.MAX_VALUE;
		for(int i=r;i<w;i++){
			for(int j=c;j<h;j++){
				grid[i][j]=0;
				int val=solve(left-1,w,h,i,j+1,grid);
				minDist=Math.min(minDist,val);
				grid[i][j]=-1;
			}
		}
		return minDist;
	}
	static class Location{
		int first,second;
		public Location(int a,int b){
			this.first=a;
			this.second=b;
		}
	}


	public static void main(String[] args) {
		nov n = new nov();
		char a = (char) ('a'+25);
		String s="abbcccb";
		System.out.println("inital: "+s);
		System.out.println("word: "+n.compressWord(s, 2));
	}
}
