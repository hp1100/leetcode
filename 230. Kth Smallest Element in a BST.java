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
    
    int count = 0;
    int res = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return res;
    }
    
    public void inOrder(TreeNode root){
        if(root == null) return;
        
        inOrder(root.left);
        if(--count == 0) res = root.val;
        inOrder(root.right);
    }
}
