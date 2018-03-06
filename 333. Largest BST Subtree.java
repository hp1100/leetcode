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
    
    class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;
        
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int maxSize = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        // if (root == null) { return 0; }    
        traverse(root);
        return maxSize;
    }
    
    private Result traverse(TreeNode node){
        if(node == null) 
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); 
        
        Result left = traverse(node.left);
        Result right = traverse(node.right);
        
        if(left.size < 0 || right.size < 0 || node.val <= left.upper || node.val >= right.lower) 
            return new Result(-1, 0, 0);
        
        int size = left.size + right.size + 1;
        maxSize = Math.max(maxSize, size);
        
        return new Result(size, Math.min(node.val, left.lower), Math.max(node.val, right.upper));
    }
}
