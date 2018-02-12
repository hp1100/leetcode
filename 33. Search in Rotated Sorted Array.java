public class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while(lo < hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] > nums[hi]) lo = mid + 1;
            else hi = mid;
        }
        // lo==hi is the index of the smallest value and also the number of places rotated.
        int rot = lo;
        lo = 0; 
        hi = nums.length - 1;
        // The usual binary search and accounting for rotation.
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % nums.length;
            if(nums[realmid] == target) return realmid;
            if(nums[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}
// easy to understand way:
// divide [4 5 6 7 0 1 2] into [4 5 6 7] and [0 1 2]
// then binary search in each subarray
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        
        int pos = findMin(nums);
        // find in left sorted subarray
        int left = binarySearch(nums, 0, pos - 1, target);
        // find in right sorted subarray
        int right = binarySearch(nums, pos, nums.length - 1, target);
        
        return left != -1 ? left : (right != -1 ? right : -1);
    }
    
    // binary search : if find, return index, else return -1
    public int binarySearch(int[] nums, int lo, int hi, int target){
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    // find the minimum element to divide array
    private int findMin(int[] nums) {
        if (nums == null || nums.length == 0)  return -1;

        int lo = 0, hi = nums.length - 1, target = nums[hi];
        
        while(lo + 1 < hi){
            int mid = (hi - lo) / 2 + lo;
            if(nums[mid] <= target){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        return nums[lo] <= nums[hi] ? lo : hi;
    }
}
