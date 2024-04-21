package msit_5214;

public class MinimumDistanceBetweenBSTNodes783 {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	
	TreeNode prev = null;
	int result = Integer.MAX_VALUE;
	
	public int minDiffInBST(TreeNode root) {
        // we have binary tree, i.e. in-oder gives us sorted order.
		// if so, to calculate minimum we have to take two adjacent nodes. 
		// and keep track of previous node
		dfs(root);
		
		return result;
    }
	
	private void dfs(TreeNode node) {
		if(node == null) {
			return;
		}
		
		dfs(node.left);
		
		if(prev != null) {
			result = Math.min(result, node.val - prev.val);
		}
		prev = node;
		
		dfs(node.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
