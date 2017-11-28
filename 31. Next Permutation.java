class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int k = -1, l = 0;
        // find the largest index k which nums[k] < nums[k+1]
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]) k = Math.max(k, i);
        }
        // if the index k does not exist(k == -1), reverse the whole array
        if(k == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        // find the largest index l which nums[k] < nums[l]
        for(int i = k + 1; i < nums.length; i++){
            if(nums[i] > nums[k]) l = Math.max(l, i);
        }
        // swap value of nums[k] with nums[l]
        if(k != -1){
            int temp = nums[k];
            nums[k] = nums[l];
            nums[l] = temp;
        }
        // reverse the nums[k+1:]
        reverse(nums, k+1, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
