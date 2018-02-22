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
    public int minDepth(TreeNode root) {
        
        if(root == null) return 0;
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        // bfs
        while(!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left == null && cur.right == null) return depth;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        
        return depth;
    }
}
