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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new LinkedList<>();
        inorder(root, res, target, k);
        return res;
    }
    
    private void inorder(TreeNode node, List<Integer> res, double target, int k){
        if(node == null) return;
        inorder(node.left, res, target, k);
        
        if(res.size() < k)
            res.add(node.val);
        else if(Math.abs(node.val - target) > Math.abs(res.get(0) - target))
            return;
        else{
            res.remove(0);
            res.add(node.val);
        }
        
        inorder(node.right, res, target, k);
    }
}
