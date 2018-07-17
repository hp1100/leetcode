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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<TreeNode, Integer> cols = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        cols.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = cols.get(node);
            
            map.computeIfAbsent(col, k -> new LinkedList<>()).add(node.val);
  
            if (node.left != null) {
                queue.offer(node.left);
                cols.put(node.left, col - 1);
            }
            
            if (node.right != null) {
                queue.offer(node.right);
                cols.put(node.right, col + 1);
            }
            min = Math.min(min, col);
        }
        while(map.containsKey(min)) 
            res.add(map.get(min++));
        return res;
    }
    
}
