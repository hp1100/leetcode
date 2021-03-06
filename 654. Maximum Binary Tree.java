/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Recursive fucntion 
// Time Complexity
// avg : O(nlgn)  worst : O(n^2)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1, null);
    }
    
    private TreeNode helper(int[] nums, int lo, int hi, TreeNode node) {
        if(lo > hi || lo < 0 || hi >= nums.length) return null;
        int idx = findIndexOfMaximum(nums, lo, hi);
        int max = nums[idx];
        node = new TreeNode(max);
        node.left = helper(nums, lo, idx - 1, node.left);
        node.right = helper(nums, idx + 1, hi, node.right);
        return node;
    }
    
    private int findIndexOfMaximum(int[] nums, int lo, int hi){
        int res = lo;
        for(int i = lo + 1; i <= hi; i++) {
            if(nums[i] > nums[res])
                res = i;
        }
        return res;
    }
    
}


// Iterative function
// Time compleixty: O(n)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
}
