class Solution {
    public int preimageSizeFZF(int K) {
        return count(K + 1) - count(K);
    }
    
    private int count(int k) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo <= hi) {
            long mid = (hi - lo) / 2 + lo;
            if (countFive(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return (int)lo;
    }
    
    private long countFive(long x) {
        long res = 0;

        for (; x > 0; x /= 5) {
            res += x/5;
        }

        return res;
    }
}
