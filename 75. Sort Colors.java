class Solution {
    public void sortColors(int[] nums) {
        int second = nums.length - 1, zero = 0;
        for(int i = 0; i <= second; i++){
            while(nums[i] == 2 && i < second){
                int temp = nums[i];
                nums[i] = nums[second];
                nums[second] = temp;
                second--;
            }
            while(nums[i] == 0 && i > zero){
                int temp = nums[i];
                nums[i]= nums[zero];
                nums[zero] = temp;
                zero++;
            }
        }
    }
}
