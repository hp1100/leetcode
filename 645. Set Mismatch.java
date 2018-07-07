// O(1) time O(1) Space
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int curSum = 0, orgSum = nums.length * (nums.length + 1) / 2;
        for (int num : nums) {
            curSum += Math.abs(num);
            if (nums[Math.abs(num) - 1] < 0) 
                res[0] = Math.abs(num);
            else 
                nums[Math.abs(num) - 1] *= -1;
        }
        res[1] = res[0] + (orgSum - curSum);
        return res;
    }
}
