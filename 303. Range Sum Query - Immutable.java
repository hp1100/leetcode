class NumArray {
    
    int[] prefixSum;

    public NumArray(int[] nums) {
        prefixSum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return prefixSum[j + 1] - prefixSum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */


---------------------------Segement Tree Method-------------------------
    
class NumArray {
    
    class SegmentTreeNode {
        int start, end, sum;
        SegmentTreeNode left, right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }
    
    public SegmentTreeNode root = null;
    
    public SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if(start == end) { 
            node.sum = nums[start];
        }else {
            int mid = (end - start) / 2 + start;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }

    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if(root.start == start && root.end == end) return root.sum;
        
        int mid = (root.end - root.start) / 2 + root.start;
        if(mid >= end) {
            return sumRange(root.left, start, end);
        }else if(mid + 1 <= start) {
            return sumRange(root.right, start, end);
        }else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
        
    }
}
