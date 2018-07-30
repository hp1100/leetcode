// Time complexity: O(n^2)
// test case : b b b a b 
//             1 2 3 3 4
//             x 1 2 2 3
//             x x 1 1 3
//             x x x 1 1
//             x x x x 1
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                }else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 + dp[i + 1][j - 1] : Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
