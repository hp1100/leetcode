//Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.

//Sort the array "int[] nums" to make sure we can skip the same value.

//when a number has the same value with its previous, we can use this number only if his previous is used

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, boolean[] used){
        if(temp.size() == nums.length) 
            res.add(new ArrayList<>(temp));
        else{
            for(int i = 0; i < nums.length; i++){
                if(used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue ;
                used[i] = true;
                temp.add(nums[i]);
                backtrack(res, temp, nums, used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
