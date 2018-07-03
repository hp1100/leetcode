// O(2^n)
public class Solution {
    
    int count = 0;
    
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, S, 0, 0);
        return count;
    }
    
    private void dfs(int[] nums, int S, int sum, int idx){
        if(idx == nums.length && sum == S) count++;
        if(idx >= nums.length) return;
        dfs(nums, S, sum + nums[idx], idx + 1);
        dfs(nums, S, sum - nums[idx], idx + 1);
    }
}



// O(Math.max(S, n))
class Solution {
    
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        return sum < S || (S + sum) % 2 > 0 ? 0 : subsetSum(nums, (S + sum) >>> 1); 
    }
    
    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) 
            for (int i = target; i >= num; i--)
                dp[i] += dp[i - num];
        return dp[target];
    }

}
