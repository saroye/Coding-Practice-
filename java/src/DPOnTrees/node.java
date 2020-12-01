package DPOnTrees;

public class node {

	node left;
	node right;
	int val;
	node(node left, node right, int val){
		this.left=left;
		this.right=right;
		this.val=val;
	}
	public node(int val){
		this.val=val;
	}
	public node getLeft() {
		return left;
	}
	public node getRight() {
		return right;
	}
	public void setRight(node right) {
		 this.right=right;
	}
	public void setLeft(node left) {
		 this.left=left;
	}

}
