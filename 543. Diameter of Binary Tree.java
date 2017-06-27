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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        
        return Math.max(left > right ? left : right, depthOfBinaryTree(root.left) + depthOfBinaryTree(root.right));
    }
    
    public int depthOfBinaryTree(TreeNode root){
        if(root == null) return 0;
        return Math.max(depthOfBinaryTree(root.left), depthOfBinaryTree(root.right)) + 1;
    }
}
