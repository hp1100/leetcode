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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (!isUnivalTree(root.left) || !isUnivalTree(root.right)) return false;
        if (root.left != null && root.val != root.left.val) return false;
        if (root.right != null && root.val != root.right.val) return false;
        return true;
    }
}
