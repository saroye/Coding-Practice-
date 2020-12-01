package Recursion;

import DPOnTrees.node;

public class heighofBTree {

	public int height(node root) {
		if(root==null) {
			return 0;
		}
		int lh=height(root.getLeft());
		int rh=height(root.getRight());
		return 1+Math.max(lh, rh);
	}
	
	
	public static void main(String[] args) {
		heighofBTree h = new heighofBTree();
		System.out.println(h.height(new node(8)));
	}
}
