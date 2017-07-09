public class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 5;
        if(n < 2)
            return dp[n];
        for(int i = 2; i <= n; i++){
            int curResult = 0;
            int j = 1;
            while(j <= i/2){
                curResult += dp[i-j] * dp[j-1] * 2;
                j++;
            }
            if(i % 2 == 1){
                curResult += dp[i-j] * dp[j-1];
            }
            dp[i] = curResult;
        }
        return dp[n];
    }
}
