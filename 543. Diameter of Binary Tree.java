/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// O(n^2) 
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

// O(n) 
class Solution {
    
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}
