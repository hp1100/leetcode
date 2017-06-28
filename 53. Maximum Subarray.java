public class Solution {
    public int maxSubArray(int[] nums) {
        //if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int max = nums[0], min = nums[0];
        int[] presum = new int[nums.length];
        presum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            presum[i] = presum[i - 1] + nums[i];
            if(presum[i] - min > max || presum[i] > max) max = Math.max(presum[i] - min, presum[i]);
            if(presum[i] < min) min = presum[i];
        }
        return max;
    }
}
