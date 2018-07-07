// O(n) time O(n) space
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (i % 2 == 0) ? (i / 2) * (i / 2) : (i / 2) * (i - i / 2);
            for (int j = 1; j <= 3 && j <= i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }
}
