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
    
    double diff = Double.MAX_VALUE;
    int res = 0;
    
    public int closestValue(TreeNode root, double target) {
        binarySearch(root, target);
        return res;
    }
    
    public void binarySearch(TreeNode node, double target){
        if(node == null) return;
        
        if(Math.abs(node.val - target) < diff){
            res = node.val;
            diff = Math.abs(node.val - target);
        }
        
        if(node.val > target)
            binarySearch(node.left, target);
        else
            binarySearch(node.right, target);
    }
}
