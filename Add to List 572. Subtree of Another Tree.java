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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        
        if(s.val == t.val && isSameTree(s ,t)) return true;
        
        if(isSubtree(s.left, t) || isSubtree(s.right, t)) return true;
        
        return false;
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) return true;
        if(s == null || t == null || s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
