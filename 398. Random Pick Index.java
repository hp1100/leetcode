class Solution {
    
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }
    
    public int pick(int target) {
        int n = 1;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && random.nextInt(n++) == 0)
                res = i;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
