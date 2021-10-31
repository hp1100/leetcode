class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = quickselect(nums, lo, hi);
            if (mid == k) break;
            if (mid > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return nums[k];
    }
    
    private int quickselect(int[] nums, int lo, int hi) {
        int pivot = nums[lo], i = lo + 1, j = hi;
        while (true) {
            while (i < hi && nums[i] < pivot) i++;
            while (j > lo && nums[j] >= pivot) j--; // find elements < pivot
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
