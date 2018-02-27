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
    
    int tiltSum = 0;
    
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tiltSum;
    }
    
    private int postOrder(TreeNode node) {
        if(node == null) return 0;
        
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        
        tiltSum += Math.abs(left - right);
        
        return node.val + left + right;
    }
}
