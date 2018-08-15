class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0, curSum = 0;
        for (int num : nums) totalSum += num;
        for (int i = 0; i < nums.length; i++) {
            if (totalSum - curSum - nums[i] == curSum) return i;
            curSum += nums[i];
        }
        return -1;
    }
}
