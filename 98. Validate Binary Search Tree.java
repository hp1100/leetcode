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
    public boolean isValidBST(TreeNode root) {
        return isValidSubBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidSubBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValidSubBST(root.left, min, root.val) && isValidSubBST(root.right, root.val, max);
    }
}
