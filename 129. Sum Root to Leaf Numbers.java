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
    
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    
    private int sum(TreeNode node, int prefix) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return prefix * 10 + node.val;
        return sum(node.left, prefix * 10 + node.val) + sum(node.right, prefix * 10 + node.val);
    }
}
