class Solution {
    int MOD = 1000000007;
    
    public int checkRecord(int n) {
        // withoutA_endL, withoutA_endLL, withoutA_endP, withA_endA, withA_endP, withA_endL, withA_endLL 
        //        0            1               2              3           4          5           6
        int[] dp = {1, 0, 1, 1, 0, 0, 0};
        
        for (int i = 2; i <= n; i++) {
            dp = new int[]{dp[2], dp[0], sum(dp, 0, 2), sum(dp, 0, 2), sum(dp, 3, 6), sum(dp, 3, 4), dp[5]};
        }
        
        return sum(dp, 0, 6);
    }
    
    private int sum(int[] arr, int l, int r) {
        int res = 0;
        for (int i = l; i <= r; i++) {
            res = (res + arr[i]) % MOD;
        }
        return res;
    }
}
