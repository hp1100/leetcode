class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                if(nums[i] + nums[lo] + nums[hi] < target) {
                    // key:
                    count += hi - lo;
                    lo++;
                }else{
                    hi--;
                }
            }
        }
        return count;
    }
}
