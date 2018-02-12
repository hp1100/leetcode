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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> level = new LinkedList<>();
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        curLevel.offer(root);
        while(!curLevel.isEmpty()){
            TreeNode temp = curLevel.poll();
            //if(temp == null) continue;
            level.add(temp.val);
            if(temp.left != null) nextLevel.offer(temp.left);
            if(temp.right != null) nextLevel.offer(temp.right);
            if(curLevel.isEmpty()){
                curLevel = new LinkedList<>(nextLevel);
                nextLevel.clear();
                res.add(new LinkedList<>(level));
                level.clear();
            }
        }
        return res;
    }
}


// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        
        if(root != null) queue.offer(root);
        
        while(!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        
        return res;
    }
}
