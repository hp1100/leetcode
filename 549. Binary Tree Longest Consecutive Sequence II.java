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
    
    private int maxLen;
    
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        helper(root);
        return maxLen;
    }
    
    private int[] helper(TreeNode node){
        if(node == null) return new int[]{0, 0};
        
        int inr = 1, dcr = 1;
        
        if(node.left != null){
            int[] len = helper(node.left);
            if(node.val == node.left.val + 1) dcr = len[1] + 1;
            else if(node.val == node.left.val - 1) inr = len[0] + 1;
        }
        
        if(node.right != null){
            int[] len = helper(node.right);
            if(node.val == node.right.val + 1) dcr = Math.max(dcr, len[1] + 1);
            else if(node.val == node.right.val - 1) inr = Math.max(inr, len[0] + 1);
        }
        
        maxLen = Math.max(maxLen, inr + dcr - 1);
        return new int[]{inr, dcr};
        
    }
}
