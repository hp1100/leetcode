public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre_sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i = 0; i < nums.length; i++){
            pre_sum += nums[i];
            if(map.containsKey(pre_sum - k)) count += map.get(pre_sum - k);
            map.put(pre_sum, map.getOrDefault(pre_sum, 0) + 1);
        }
        return count;
    }
}
