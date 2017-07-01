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
    
    int flag = 0;
    
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        if(flag == 1) return false;
        return true;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        
        int left_depth = dfs(root.left);
        int right_depth = dfs(root.right);
        
        if(Math.abs(left_depth - right_depth) > 1) flag = 1;
        
        return Math.max(left_depth, right_depth) + 1;
    }
}
