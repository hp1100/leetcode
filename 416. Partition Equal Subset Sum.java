public class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0) return true;
        //preprocess
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 == 1) return false;
        sum /= 2;
        //dp def
        boolean[] dp = new boolean[sum + 1];
        //dp init
        dp[0] = true;
        //dp transition
        for(int i = 1; i <= nums.length; i++){
            for(int j = sum; j >= nums[i - 1]; j--){
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[sum];
    }
}
