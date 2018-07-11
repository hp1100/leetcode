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
    
    int deepestLevel = 0;
    TreeNode res = null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    
    private int dfs(TreeNode root, int level) {
        if (root == null) return level;
        
        int left = dfs(root.left, level + 1);
        int right = dfs(root.right, level + 1);
        
        int curLevel = Math.max(left, right);
        deepestLevel = Math.max(deepestLevel, curLevel);
        if (left == deepestLevel && right == deepestLevel)
            res = root;
        return curLevel;
    }
}
