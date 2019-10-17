class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int i = findFirstInsertPlace(nums, target);
        if (i < nums.length && nums[i] == target) {
            return new int[]{i, findFirstInsertPlace(nums, target+1)-1};
        } else {
            return new int[]{-1, -1};
        }
    }
    
    private int findFirstInsertPlace(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] >= target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
