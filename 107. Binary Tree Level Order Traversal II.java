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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
                
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new LinkedList<>();
            
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            
            res.add(0, currLevel);
        }
        
        return res;
    }
}
