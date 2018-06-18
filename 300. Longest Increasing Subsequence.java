// 2017/07/11
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


// 2018/06/18 DP O(n^2)
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length, res = 1;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], nums[i] > nums[j] ? dp[j] + 1 : 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
