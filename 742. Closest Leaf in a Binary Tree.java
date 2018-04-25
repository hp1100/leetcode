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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> back = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        TreeNode target = dfs(root, k, back);
        queue.offer(target);
        visited.add(target);
        
        // bfs
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null) return cur.val;
            
            if(cur.left != null && visited.add(cur.left)) queue.offer(cur.left);
            
            if(cur.right != null && visited.add(cur.right)) queue.offer(cur.right);
            
            if(back.containsKey(cur) && visited.add(back.get(cur))) queue.offer(back.get(cur));
        }
        
        return -1;
    }
    
    private TreeNode dfs(TreeNode root, int k, Map<TreeNode, TreeNode> back) {
        if(root.val == k) return root;
        
        if(root.left != null) {
            back.put(root.left, root);
            TreeNode left = dfs(root.left, k, back);
            if(left != null) return left;
        }
        
        if(root.right != null) {
            back.put(root.right, root);
            TreeNode right = dfs(root.right, k, back);
            if(right != null) return right;
        }
        
        return null;
    }
}
