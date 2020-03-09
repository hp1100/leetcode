class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(helper(n - 1, nums, 0), helper(n - 1, nums, 1));
    }
    
    
    private int helper(int n, int[] nums, int offset) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = Math.max(dp[(i + n - 1) % n][0], dp[(i + n - 1) % n][1]);
            dp[i][1] = Math.max(dp[(i + n - 1) % n][0], dp[(i + n - 2) % n][1]) + nums[i + offset];
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}
