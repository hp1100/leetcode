class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0 ) return 0;
        int n = costs.length, k = costs[0].length;
        int[][] dp = new int[n][k];
        for(int i = 0; i < k; i++)
            dp[0][i] = costs[0][i];
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < k;j++) {
                for(int c = 1; c < k; c++) {
                    if(c == 1) dp[i][j] = dp[i - 1][(j + 1) % k];
                    else dp[i][j] = Math.min(dp[i - 1][(j + c) % k], dp[i][j]);
                }
                dp[i][j] += costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < k; i++)
            res = Math.min(res, dp[n - 1][i]);
        return res;
    }
}
