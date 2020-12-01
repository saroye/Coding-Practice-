package Interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


	static int[] ax={1,-1,0,0};
	static int[] ay={0,0,-1,1};
	public static int findMinDistance(int w, int h, int n) {
		int[][] grid=new int[w][h];
		for(int i=0;i<w;i++){
			Arrays.fill(grid[i],-1);
		}
		return solve(n,w,h,0,0,grid);
	}
	static int BFS(int w,int h,int grid[][]){
		int[][] dist=new int[w][h];
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				dist[i][j]=grid[i][j];
			}
		}
		int Dist=0;
		Queue<dimension> queue=new LinkedList<>();
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				if(dist[i][j]==0){
					queue.add(new dimension(i,j));
				}
			}
		}
		while(!queue.isEmpty()){
			int x=queue.peek().x;
			int y=queue.peek().y;
			Dist=Math.max(Dist,dist[x][y]);
			queue.poll();
			for(int d=0;d<4;d++){
				int newX=x+ax[d];
				int newY=y+ay[d];
				if(newX>=w||newY>=h||newX<0||newY<0)
					continue;
				if(dist[newX][newY]==-1){
					dist[newX][newY]=dist[x][y]+1;
					queue.add(new dimension(newX,newY));
				}
			}
		}
		return Dist;
	}
	static int solve(int left,int w,int h,int row,int col,int[][]grid){
		if(left==0)
			return BFS(w,h,grid);
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
	static class dimension{
		int x,y;
		public dimension(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
}