class Solution {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            while (lo < hi && nums[lo] == nums[hi]) lo++;
            int mid = (hi - lo) / 2 + lo;
            if (nums[mid] == target) return true;
            
            if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] <= nums[hi]){
                if (nums[hi] >= target && target > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            //System.out.println(lo + " : "+hi);
        }
        return false;
    }
}
