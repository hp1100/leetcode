public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int num: nums){
            if(!map.containsKey(num)){
                int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
                
                int len = left + right + 1;
                res = Math.max(res, len);
                map.put(num ,len);
                
                map.put(num - left, len);
                map.put(num + right, len);
            }else{
                continue;
            }
        }
        return res;
    }
}
