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
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if (N % 2 == 0) 
            return res;
        if (N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for (int i = 0; i <= N - 1; i++) {
            List<TreeNode> lefts = allPossibleFBT(i);
            List<TreeNode> rights = allPossibleFBT(N - i - 1);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
