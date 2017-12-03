 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int maxLen = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        dfs(root, root.val);
        return maxLen;
        
    }
    
    private int dfs(TreeNode node, int val){
        if(node == null) return 0;
        int left = dfs(node.left, node.val);
        int right = dfs(node.right, node.val);
        maxLen = Math.max(maxLen, left + right);
        if(node.val == val) return Math.max(left, right) + 1;
        return 0;      
    }
}
