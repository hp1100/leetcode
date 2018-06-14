// dp O(n^2)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for(int j = 1; j < n; j++) {
            for(int i = 0; i < j; i++) {
                if(i + nums[i] >= j) {
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }
        
        //for(int i = 0; i < n; i++)
            //System.out.println(dp[i]);
        
        return dp[n-1];
    }
}

// Greedy O(n)
class Solution {
    public int jump(int[] nums) {
        int curFarthest = 0, jump = 0, curEnd = 0;
        for(int i = 0; i < nums.length - 1; i++) { // important detail: the length is nunm.length - 1 but not nums.length
            if(i + nums[i] > curFarthest) curFarthest = i + nums[i];
            if(i == curEnd) {
                jump++;
                curEnd = curFarthest;
            }
        }
        return jump;
    }
}
