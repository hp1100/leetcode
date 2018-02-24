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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {
        
        List<TreeNode> res = new LinkedList<>();
        
        if(start > end) {
            res.add(null);
            return res;
        }
        
        if(start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        
        for(int i = start; i <= end; i++) {
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i + 1, end);
            
            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
    } 
}
