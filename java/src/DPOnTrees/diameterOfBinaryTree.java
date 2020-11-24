package DPOnTrees;
/**
 *  @author Saroye
 *  
 *	"how to identify DP on trees"
 * 	Given a B-tree. Find longest path between 2 trees.
 * 	for every node find (left height + right height + 1).
 * 	
 * General approach:
 * int solve(Node root, int result){
 *   if(root==null){
 *   return 0;
 *   }	
 *   int left =solve(root.left, res);
 *   int right=solve(root.right, res);
 *   int temp=________________;
 *   int ans= max(temp, ___________);
 *   res=max(res,ans)
 * 
 */
public class diameterOfBinaryTree {

	public int diameter(node root, int res) {
		if(root==null) {
			return 0;
		}
		int left=diameter(root.left, res);
		int right=diameter(root.right, res);
		
		int temp = 1 + Math.max(left, right);
		int ans=Math.max(temp, 1+left+right);
		res=Math.max(res, ans);
		
		return temp;
	}
	
	
	public static void main(String[] args ) {
		diameterOfBinaryTree d = new diameterOfBinaryTree();
		int res=Integer.MIN_VALUE;
		node root = new node(9);
		System.out.println(d.diameter(root, res));
	}
}
