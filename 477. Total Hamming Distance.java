class Solution {
    public int totalHammingDistance(int[] nums) {
        int res = 0, n = nums.length;
        for(int j = 0; j < 32; j++) {
            int count = 0;
            for(int i = 0; i < n; i++) 
                count += (nums[i] >> j) & 1;
            res += count * (n - count);
        }
        return res;
    }
}
