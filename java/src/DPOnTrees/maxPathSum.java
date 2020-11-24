package DPOnTrees;

/**
 * 
 * given a tree with certian values. 
 * find the max sum of the nodes.
 * 
 * @author Saroye
 *
 */
public class maxPathSum {
	
	
	/**
	 * can vary from node and pick the max sum from all over the tree.
	 * @param root
	 * @param res
	 * @return
	 */
	public int maxSum(node root, int res) {

		if(root==null) {
			return 0;
		}
		int left=maxSum(root.left, res);
		int right=maxSum(root.right, res);
		
		int temp =Math.max(Math.max(left,right)+root.val, root.val);
		int ans=Math.max(temp, left+right+root.val);
		
		res=Math.max(temp, ans);
		return temp;
	}
	
	/**
	 * this has to start from a leaf and end at a leaf.
	 * gives the max sum for all leaf nodes.
	 * @param root
	 * @param res
	 * @return
	 */
	public int MaxSumLeaf2Leaf(node root, int res) {
		if(root==null) {
			return 0;
		}
		int left=MaxSumLeaf2Leaf(root.left, res);
		int right=MaxSumLeaf2Leaf(root.right, res);
		
		int temp =Math.max(left,right)+root.val;
		if(root.left==null && root.right==null) {
			temp=Math.max(temp, root.val);
		}
		
		int ans=Math.max(temp, left+right+root.val);
		res=Math.max(res, ans);
		return temp;
	}

	public static void main(String[] args) {
		maxPathSum m = new maxPathSum();
		int res=Integer.MIN_VALUE;
		node root = new node(9);
		System.out.println(m.maxSum(root, res));
	}

}
