// one pass
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, beg = -1, end = -2, min = nums[n - 1], max = nums[0];
        for(int i = 1; i < n; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n-1-i]);
            if(nums[i] < max) end = i;
            if(nums[n-1-i] > min) beg = n-1-i;
        }
        return end - beg + 1;
    }
}


// two pass
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l = 0, r = nums.length - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        while(l < r && nums[l] <= nums[l + 1]) l++;
        if(l == r) return 0;
        while(nums[r] >= nums[r - 1]) r--;
        
        for(int i = l; i <= r; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        while(l >= 0 && nums[l] > min) l--;
        while(r < nums.length && nums[r] < max) r++;
        
        return r - l - 1;
    }
}
