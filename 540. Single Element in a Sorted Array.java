public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int pre = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(i % 2 == 1){//even like idx = 1 is the second number in array
                if(nums[i] != pre) return pre;
            }else{//odd
                pre = nums[i];
            }
        }
        return pre;
    }
}
