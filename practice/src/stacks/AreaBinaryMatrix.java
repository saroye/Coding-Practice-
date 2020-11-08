package stacks;

import java.util.Arrays;
import java.util.Stack;

public class AreaBinaryMatrix {

	public void areaOfBinary(int[][] ar) {
		int[] h1=new int[ar[0].length];
		int max=0;
		for(int i=0; i<ar[0].length; i++) {
			h1[i]=ar[0][i];
		}

		System.out.println("Before: "+Arrays.toString(h1));
		max=maxArea(h1);
		for(int i=1;i<ar.length; i++) {
			for(int j=0;j<ar[0].length; j++) {
				if(ar[i][j] !=0 ) {
					h1[j]=h1[j]+ar[i][j];
				}
				else {
					h1[j]=0;
				}
			}
			System.out.println("***************");
			max=maxArea(h1);
		}
	}
	public int maxArea(int[] ar) {
		int[] left=leftSide(ar);
		int[] right=rightSide(ar);
		int[] width=new int[ar.length];
		int[] area=new int[ar.length];
		int maxArea=0;
		for(int i=0; i<width.length; i++) {
			width[i] = (right[i]-left[i])-1;
		}
		for(int i=0; i<width.length; i++) {
			int a=ar[i]*width[i];
			area[i]=a;
			if(maxArea<=a) {
				maxArea=a;
			}
		}
		System.out.println("Width:  "+Arrays.toString(width));
		System.out.println("======");
		System.out.println("Area:   "+Arrays.toString(area));
		System.out.println("======");
		System.out.println("MaxAr:  "+maxArea);
		return maxArea;
	}

	public int[] leftSide(int[] ar) {
		int[] left=new int[ar.length];
		Stack<pair> s = new Stack<pair>();
		
		for(int i =0; i<ar.length; i++) {
			if(s.isEmpty()) {
				left[i]=-1;
			}
			else if(s.size()>0 && s.peek().getElt()<ar[i]) {
				left[i]=s.peek().getI();
			}
			else if(s.size()>0 && s.peek().getElt()>=ar[i]) {
				while(s.size()>0 && s.peek().getElt()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					left[i]=-1;
				}
				else {
					left[i]=s.peek().getI();
				}
			}
			s.push(new pair(i,ar[i]));
		}
		System.out.println("Left:   "+ Arrays.toString(left));
		return left;
	}
	public int[] rightSide(int[] ar) {
		int[] right=new int[ar.length];
		Stack<pair> s = new Stack<pair>();
		for(int i =ar.length-1; i>=0; i--) {
			if(s.isEmpty()) {
				right[i]=ar.length;
			}
			else if(s.size()>0 && s.peek().getElt()<ar[i]) {
				right[i]=s.peek().getI();
			}
			else if(s.size()>0 && s.peek().getElt()>=ar[i]) {
				while(s.size()>0 && s.peek().getElt()>=ar[i]) {
					s.pop();
				}
				if(s.size()==0) {
					right[i]=ar.length;
				}
				else {
					right[i]=s.peek().getI();
				}
			}
			s.add(new pair(i,ar[i]));
		}
		System.out.println("Right:  "+ Arrays.toString(right));
		return right;
	}

	public static void main(String[] args) {

		AreaBinaryMatrix a = new AreaBinaryMatrix();
		int[][] ar= new int[][] {{0,1,1,0}, {1,1,1,1},{1,1,1,1},{1,1,0,0}};
		for(int i=0; i<ar.length; i++) {
			System.out.println(Arrays.toString(ar[i]));
		}

		System.out.println("***************");
		a.areaOfBinary(ar);

	}

}