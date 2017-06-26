//The most common idea is to first inOrder traverse the tree and compare the delta between each of the adjacent values. 
//It's guaranteed to have the correct answer because it is a BST thus inOrder traversal values are sorted.
//Solution 1 - In-Order traverse, time complexity O(N), space complexity O(1).

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return min;
        
        getMinimumDifference(root.left);
        
        if(prev != null) min = Math.min(min, root.val - prev);
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
        
    }
}
