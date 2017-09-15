class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // when find a number i, flip the number at position i-1 to negative. 
        // if the number at position i-1 is already negative, i is the number that occurs twice.
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < nums.length; i++){
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0){
                nums[val] = -nums[val];
            }else{
                res.add(val + 1);
            }
        }
        return res;
    }
}
