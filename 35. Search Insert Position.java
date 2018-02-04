class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] == target) return mid;
            if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}
