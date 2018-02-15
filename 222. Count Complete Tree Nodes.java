/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time complexity: O((logn)^2)
// Treavel tree logn times
// every time check height cost logn time
class Solution {
    public int height(TreeNode node){
        return node == null ? -1 : height(node.left) + 1;
    }
    
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 : 
        height(root.right) == (h - 1) ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }
}
