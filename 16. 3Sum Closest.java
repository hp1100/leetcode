class Solution {
    public int threeSumClosest(int[] nums, int target) {
        //if(nums == null || nums.length < 3) return ;
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++){
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target) return target;
                if(Math.abs(target - res) > Math.abs(target - sum))
                    res = sum;
                if(sum > target) hi--;
                else lo++;
            }
        }
        return res;
    }
}
