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
    
    int res = 0;
    
    public int pathSum(TreeNode root, int sum) {
        DFS(root, sum);
        return res;
    }
    
    public void DFS(TreeNode root, int sum) {
        if(root == null) return;
        isValidPath(root, sum);
        DFS(root.left, sum);
        DFS(root.right, sum);
    }
    
    public void isValidPath(TreeNode root, int sum){
        if(root == null) return ;
        if(root.val == sum) res++;
        isValidPath(root.left, sum - root.val);
        isValidPath(root.right, sum - root.val);
    }
}
