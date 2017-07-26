public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] res = new int[]{-1, -1};
        
        if(nums == null || nums.length == 0) return res;
        
        //Search the left one
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid;
        }
        
        if(nums[lo] != target) return res;
        else res[0] = lo;
        
        //Search the right one
        hi = nums.length - 1; //We don't have to set i to 0 the second time.
        while(lo < hi){
            int mid = (lo + hi) / 2 + 1;
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid;
        }
        res[1] = lo;
        return res;
    }
}
