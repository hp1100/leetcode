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
    
    private int longest = 0;
    
    public int longestConsecutive(TreeNode root){
        helper(root);
        return longest;
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        int ans;
        
        if(left == 0 && right == 0) ans = 1;
        else if(left == 0) ans = (root.right.val - root.val == 1 ? right + 1 : 1);
        else if(right == 0) ans = (root.left.val - root.val == 1 ? left + 1 : 1);
        else{
            ans = 1;
            if(root.left.val - root.val == 1) ans = Math.max(ans, left+1);
            if(root.right.val - root.val == 1) ans = Math.max(ans, right+1);
        }
        longest = Math.max(longest, ans);
        return ans;
    }
}
