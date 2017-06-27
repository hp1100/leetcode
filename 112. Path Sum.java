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
    
    List<Integer> sums = new ArrayList<>();
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        SumOfRootTOLeaf(root, 0);
        return sums.contains(sum);
    }
    
    public void SumOfRootTOLeaf(TreeNode root, int val){
        if(root.left == null && root.right == null) {
            sums.add(root.val + val);
            return;
        }
        if(root.left != null) SumOfRootTOLeaf(root.left, val + root.val);
        if(root.right != null) SumOfRootTOLeaf(root.right, val + root.val);
    }
}
