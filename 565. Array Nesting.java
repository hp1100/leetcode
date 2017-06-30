public class Solution {
    public int arrayNesting(int[] nums) {
        int maxsize = 0;
        for(int i = 0; i < nums.length; i++){
            int size = 0;
			for(int j = i; nums[j] >= 0; size++){
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
            }
            maxsize = Math.max(maxsize, size);
        }
        return maxsize;
    }
}
