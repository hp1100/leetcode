/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time complexity: O((logn)^2)
// Treavel tree logn times
// every time check height cost logn time
class Solution {
    public int height(TreeNode node){
        return node == null ? -1 : height(node.left) + 1;
    }
    
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 : 
        height(root.right) == (h - 1) ? (1 << h) + countNodes(root.right) : (1 << (h - 1)) + countNodes(root.left);
    }
}


//=====================================2019/11/8==============================================
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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lo = 1, hi = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nodeExist(root, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
    
    private boolean nodeExist(TreeNode root, int num) {
        boolean meetFirstOne = false;
        for (int i = 30; i >= 0; i--) {
            int k = (int)Math.pow(2, i);
            int j = Integer.bitCount(num & k);
            if (!meetFirstOne) {
                if (j == 1)
                    meetFirstOne = true;
            } else {
                if (j == 0 && root.left != null) root = root.left;
                else if (j == 1 && root.right != null) root = root.right;
                else return false;
            }
        }
        return true;
    }
}
