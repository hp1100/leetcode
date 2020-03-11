/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //dfs all the nodes of the tree, each node return two number, int[] num, 
 //num[0] is the max value while rob this node, num[1] is max value while not rob this value. 
 //Current node return value only depend on its children's value. 
 //Transform function should be very easy to understand.
 
public class Solution {
    public int rob(TreeNode root) {
        int[]res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] dfs(TreeNode root) {
        if(root == null) return new int[2];
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + root.val;
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}


================================2020.03.10 done by myself=========================================
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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        // res[0]: Maximum number could include node 
        // res[1]: Maximum number exclude node
        return Math.max(res[0], res[1]);
    }
    
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        
        return new int[]{Math.max(left[1] + right[1] + node.val, left[0] + right[0]), left[0] + right[0]};
    }
}
