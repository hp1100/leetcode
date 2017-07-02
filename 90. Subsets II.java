public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int nums[], int start){
        for(int i = start; i < nums.length; i++){
            if(i < nums.length - 1 && nums[i] == nums[i + 1]) continue ;
            temp.add(nums[i]);
            res.add(new ArrayList<>(temp));
            backtrack(res, temp, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }
}
