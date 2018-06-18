class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int n = prices.length;
        // Devide whole process into 5 parts: 1 --buy--> 2 --sell--> 3 --buy--> 4 --sell--> 5
        int[][] dp = new int[n + 1][5 + 1]; 
        
        dp[0][1] = 0;
        for (int i = 2; i <= 5; i++)
            dp[0][i] = Integer.MIN_VALUE;
        
        for (int i = 1; i <= n; i++) {
            // phase 1, 3, 5
            for (int j = 1; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (j > 1 && i >= 2 && dp[i - 1][j - 1] != Integer.MIN_VALUE)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
            }
            // phase 2, 4
            for (int j = 2; j <= 5; j += 2) {
                dp[i][j] = dp[i - 1][j - 1];
                if (i >= 2 && dp[i - 1][j] != Integer.MIN_VALUE)
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
            }
        }
        return Math.max(Math.max(dp[n][1], dp[n][3]), dp[n][5]);
    }
}
