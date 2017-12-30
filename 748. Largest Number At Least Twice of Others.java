class Solution {
    public int dominantIndex(int[] nums) {
        int[] largest = new int[2]; // largest[0] -> largest element, largest[1] -> second largest element
        largest[0] = nums[0];
        int idx = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > largest[0]){
                largest[1] = largest[0];
                largest[0] = nums[i];
                idx = i;
            }else if(nums[i] <= largest[1]){
                continue;
            }else{
                largest[1] = nums[i];
            }
        }
        if(largest[1] == 0 || largest[0] / largest[1] >= 2)
            return idx;
        else
            return -1;
    }
}
