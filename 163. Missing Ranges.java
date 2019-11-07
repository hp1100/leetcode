class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        long lo = lower, hi = upper;
        for (int i = 0; i < nums.length; i++) {
            long val = nums[i];
            if (val - lo >= 1) {
                if (val - lo == 1) {
                    res.add(val - 1 + "");
                } else {
                    long start = lo;
                    long end = val - 1;
                    res.add(start + "->" + end);
                }
            }
            lo = val + 1;
        }
        if (hi == lo) res.add(hi + "");
        if (hi - lo >= 1) res.add(lo + "->" + hi);
        return res;
    }
}
