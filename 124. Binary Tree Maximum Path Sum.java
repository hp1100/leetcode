/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }
    
    private int maxPathDown(TreeNode node){
        if(node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        max = Math.max(left + right + node.val, max);
        return Math.max(left, right) + node.val;
    }
}
