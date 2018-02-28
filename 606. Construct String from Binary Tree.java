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
    
    String res = "";
    
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        
        res += t.val;
        if(t.left != null || t.right != null) {
            res += "(";
            tree2str(t.left);
            res += ")";
        }
        
        if(t.right != null) {
            res += "(";
            tree2str(t.right);
            res += ")";
        }
        return res;
    }
}
