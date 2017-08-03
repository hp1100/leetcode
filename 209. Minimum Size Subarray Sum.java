public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, res = Integer.MAX_VALUE, i = 0, j = 0;
        while(i < nums.length){
            sum += nums[i++];
            
            while(sum >= s){
                res = Math.min(res, i - j);
                sum -= nums[j++];
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }
}
