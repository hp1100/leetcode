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
    
    List<List<Integer>> paths = new ArrayList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        helper(root, sum, path);
        return paths;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val) {
            paths.add(path);
            return;
        }
        
        helper(root.left, sum - root.val, new ArrayList<Integer>(path));
        helper(root.right, sum - root.val, new ArrayList<Integer>(path));
    }
}
