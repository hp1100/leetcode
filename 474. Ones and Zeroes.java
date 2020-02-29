class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        
        for (int i = 1; i <= len; i++) {
            
            int cnt_zero = 0;
            int cnt_one = 0;
            String str = strs[i - 1];
            for (char ch: str.toCharArray())
                if (ch == '0')
                    cnt_zero++;
                else
                    cnt_one++;    

            
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (i == 0)
                        dp[i][j][k] = 0;
                    else if (j >= cnt_zero && k >= cnt_one)
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j - cnt_zero][k - cnt_one] + 1);
                    else
                        dp[i][j][k] = dp[i-1][j][k];
                }
            }
        }
        
        return dp[len][m][n];
    }
}
