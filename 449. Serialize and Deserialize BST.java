/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if(root != null) stack.push(root);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(",");
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<Integer> queue = new LinkedList<>();
        for(String s : data.split(","))
            queue.offer(Integer.parseInt(s));
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<Integer> queue) {
        if(queue.isEmpty()) return null;
        TreeNode node = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < node.val)
            smallQueue.offer(queue.poll());
        node.left = buildTree(smallQueue);
        node.right = buildTree(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
