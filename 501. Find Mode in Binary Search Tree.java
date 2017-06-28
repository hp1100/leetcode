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
    
    Set<Integer> mode = new HashSet<>();
    int val, count, max;
    
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        
        val = root.val;
        max = Integer.MIN_VALUE;
        count = 0;
        inOrder(root);
        
        int[] res = new int[mode.size()];
        Iterator iterator = mode.iterator();
        int i = 0;
        while(iterator.hasNext()){
            res[i++] = (int)iterator.next();
        }
        return res;
    }
    
    public void inOrder(TreeNode root) {
        if(root == null) {
            if(count == max) mode.add(val);
            if(count > max){
                mode.clear();
                mode.add(val);
                max = count;
            }
            return;
        }
        inOrder(root.left);
        if(val != root.val){
            if(count == max) mode.add(val);
            if(count > max){
                mode.clear();
                mode.add(val);
                max = count;
            }
            count = 1;
            val = root.val;
        }else{
            count++;
        }
        inOrder(root.right);
    }
}
