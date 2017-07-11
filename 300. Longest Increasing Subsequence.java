public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int maxLen = 0;
        for(int len: dp){
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
