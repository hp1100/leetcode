class Solution {
    public int findMin(int[] nums) {
        
        if (nums == null || nums.length == 0)  
            return -1;
        
        int lo = 0, hi = nums.length - 1, target = nums[hi];
        
        while(lo + 1 < hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] > target){
                lo = mid;
            }else{ // nums[mid] < first
                hi = mid;
            }
        }
        
        //System.out.println(lo +  "-" + hi);
        
        //return nums[lo] > target ? nums[hi] : nums[lo];
        return Math.min(nums[lo], nums[hi]);
    }
}
