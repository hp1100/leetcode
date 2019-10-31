class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int lo = 1, hi = 0;
        for (int weight: weights) hi += weight;
        while (lo <= hi) {
            int mid = (hi - lo) / 2 + lo;
            if (goodToShipInDDays(weights, D, mid)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    private boolean goodToShipInDDays(int[] weights, int D, int capacity) {
        int count = 1, i = 0, space = capacity;
        while (i < weights.length) {
            if (weights[i] > capacity) return false;
            if (weights[i] > space) {
                count++;
                space = capacity;
            } else {
                space -= weights[i];
                i++;
            }
        }
        return count <= D;
    }
}
