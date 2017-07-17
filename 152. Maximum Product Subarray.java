public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int res = Integer.MIN_VALUE;
        // max_pos[i] means max positive porduct of subaarray end with nums[i]
        int[] max_pos = new int[nums.length + 1];
        // min_neg[i] means min negative porduct of subaarray end with nums[i]
        int[] min_neg = new int[nums.length + 1];
        
        for(int i = 1; i <= nums.length; i++){
            if(nums[i - 1] >= 0){
                max_pos[i] = Math.max(max_pos[i - 1] * nums[i - 1], nums[i - 1]);
                min_neg[i] = min_neg[i - 1] * nums[i - 1];
            }else{
                max_pos[i] = min_neg[i - 1] * nums[i - 1];
                min_neg[i] = Math.min(max_pos[i - 1] * nums[i - 1], nums[i - 1]);
            }
            res = Math.max(res, max_pos[i]);
        }
        return res;
    }
}
