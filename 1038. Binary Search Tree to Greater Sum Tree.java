/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int preSum = 0;
    
    public TreeNode bstToGst(TreeNode root) {
        rightChildfs(root);
        return root;
    }
    
    private int rightChildfs(TreeNode node) {
        if (node == null) return 0;
        int rightSum = rightChildfs(node.right);
        node.val += preSum;
        preSum = node.val;
        int leftSum = rightChildfs(node.left);
        return node.val;
    }
}

// without private
class Solution {
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
