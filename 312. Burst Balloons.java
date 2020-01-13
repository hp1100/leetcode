class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] memo = new int[n][n];
        return dfs(memo, nums, 0, n - 1);
    }
    
    private int dfs(int[][] memo, int[] nums, int left, int right) {
        if (memo[left][right] != 0) return memo[left][right];        
        for (int i = left + 1; i < right; i++) {
            memo[left][right] = Math.max(memo[left][right],
                dfs(memo, nums, left, i) + dfs(memo, nums, i, right) + nums[left] * nums[i] * nums[right]);
        }
        return memo[left][right];
    }
}
