class Solution {
    public int findDuplicate(int[] nums) {
        int idx = 0;
        while (nums[idx] > 0) {
            nums[idx] = 0 - nums[idx];
            idx = Math.abs(nums[idx]);
        }
        return idx;
    }
}
