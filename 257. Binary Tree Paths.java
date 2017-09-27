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
    
    
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if(root == null) return res;
        DFS(root, "", res);
        return res;
    }
    
    public void DFS(TreeNode root, String path, List<String> res){
        if(root.left == null && root.right == null) res.add(path + root.val);
        if(root.left != null) DFS(root.left, path + root.val + "->", res);
        if(root.right != null) DFS(root.right, path + root.val + "->", res);
    }
}
