class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, n = nums.length, i = 0;
        while(i < n){
            int j = i;
            while(i < n && nums[i] == 1) i++;
            res = Math.max(res, i - j);
            while(i < n && nums[i] == 0) i++;
        }
        return res;
    }
}
