class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = 1000;
            dp[i][1] = 1000;
            
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][0], dp[i][0]);
                dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i][1]);
            }
            
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                dp[i][0] = Math.min(dp[i - 1][1], dp[i][0]);
                dp[i][1] = Math.min(dp[i - 1][0] + 1, dp[i][1]);
            }
        }
        
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}



class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int fix = 0;
        int swap = 1;
        
        for (int i = 1; i < n; i++) {
            int fix_next = 1000;
            int swap_next = 1000;
            
            if (A[i] > A[i - 1] && B[i] > B[i - 1]) {
                fix_next = Math.min(fix, fix_next);
                swap_next = Math.min(swap + 1, swap_next);
            }
            
            if (A[i] > B[i - 1] && B[i] > A[i - 1]) {
                fix_next = Math.min(swap, fix_next);
                swap_next = Math.min(fix + 1, swap_next);
            }
            
            fix = fix_next;
            swap = swap_next;
        }
        
        return Math.min(fix, swap);
    }
}
