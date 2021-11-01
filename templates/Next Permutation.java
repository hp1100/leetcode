class Solution {
    public void nextPermutation(int[] nums) {
        // Find the largest index k such that nums[k] < nums[k + 1]. 
        // If no such index exists, just reverse nums and done.
        // Find the largest index l > k such that nums[k] < nums[l].
        // Swap nums[k] and nums[l].
        // Reverse the sub-array nums[k + 1:].
        
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) k--;
        
        if (k < 0) {
            reverseRange(nums, 0, nums.length - 1);
        } else {
            int l = nums.length - 1;
            while (nums[k] >= nums[l]) l--;
            swap(nums, k, l);
            reverseRange(nums, k + 1, nums.length - 1);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverseRange(int[] nums, int start, int end) {
        while (start < end) swap(nums, start++, end--);
    }
}
