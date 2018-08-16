class Solution {
    public int findShortestSubArray(int[] nums) {
        int res = nums.length;
        int maxFreq = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0) + 1;
            maxFreq = Math.max(freq, maxFreq);
            map.put(nums[i], freq);
        }
        Map<Integer, Integer> lastIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != maxFreq) continue;
            lastIdx.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!lastIdx.containsKey(nums[i])) continue;
            res = Math.min(lastIdx.get(nums[i]) - i + 1, res);
            lastIdx.remove(nums[i]);
        }
        return res;
    }
}
