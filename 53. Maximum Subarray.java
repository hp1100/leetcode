// 2017.6.28 Space: O(n)
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

// 2018.6.26 Space: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int preMinSum = 0;
        int largestSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum - preMinSum > largestSum) {
                largestSum = sum - preMinSum;
            }
            
            if (sum < 0) {
                preMinSum = Math.min(preMinSum, sum);
            }
        }
        return largestSum;
    }
}

// 2018.7.2 Space:O(1) do not need to record min value
class Solution {
    public int maxSubArray(int[] A) {
        int maxEndingHere = A[0], maxSoFar = A[0];
        for (int i = 1; i < A.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }
        return maxSoFar;
    }
}
