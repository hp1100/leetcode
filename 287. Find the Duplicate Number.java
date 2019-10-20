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


// 2019/10/20 Time: O(nlgn)
class Solution {
    public int findDuplicate(int[] nums) {
        int lo = 1, hi = nums.length - 1;
        while (lo < hi) {
            int p = lo, q = hi;
            int mid = (hi - lo) / 2 + lo;
            int count = 0;
            for (int num : nums)
                if (num <= mid)
                    count++;
            if (count > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
