public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        backtrack(res, new LinkedList<>(), candidates, target, 0, 0);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> temp, int[] candidates, int target, int sum, int start){
        if(sum == target) res.add(new LinkedList<>(temp));
        
        for(int i = start; i < candidates.length; i++){
            if(sum + candidates[i] > target) break;
            temp.add(candidates[i]);
            backtrack(res, temp, candidates, target, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
