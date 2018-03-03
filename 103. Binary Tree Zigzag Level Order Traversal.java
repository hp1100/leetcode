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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        boolean leftToRight = true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        
        while(!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
                if(leftToRight) {
                    curLevel.add(node.val);
                }else {
                    curLevel.add(0, node.val);
                }
            }
            res.add(curLevel);
            leftToRight = !leftToRight;
        }
        
        return res;
    }
}
