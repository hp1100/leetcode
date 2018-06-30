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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        int level = Math.max(left, right) + 1;
        if (res.size() <= level)
            res.add(new LinkedList<>());
        res.get(level).add(root.val);
        return level;
    }
}
