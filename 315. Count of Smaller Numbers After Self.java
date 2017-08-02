public class Solution {
    class Node{
        Node left, right;
        int val, sum, dup = 1;
        public Node(int v, int s){
            this.val = v;
            this.sum = s;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] res = new Integer[nums.length];
        Node root = null;
        for(int i = nums.length - 1; i >= 0; i--){
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }
    
    public Node insert(int num, Node node, Integer[] res, int i, int preSum){
        if(node == null){
            node = new Node(num, 0);
            res[i] = preSum;
        }else if(num == node.val){
            node.dup++;
            res[i] = preSum + node.sum;
        }else if(num < node.val){
            node.sum++;
            node.left = insert(num, node.left, res, i, preSum);
        }else{
            node.right = insert(num, node.right, res, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
