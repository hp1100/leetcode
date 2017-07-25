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
