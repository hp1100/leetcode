class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1;
        int hi = 1;
        for (int pile: piles) hi = Math.max(pile, hi);
        while (lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            int curH = 0;
            for (int pile : piles)
                curH += (pile % mid == 0) ? pile / mid : pile / mid + 1;
            if (curH > H) {
                lo = mid + 1;
            } else{
                hi = mid;
            }
        }
        return lo;
    }
}
