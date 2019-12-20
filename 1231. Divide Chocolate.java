class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int lo = 1, hi = (int)1e9;
        
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isGoodCut(sweetness, K, mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return hi;
    }
    
    private boolean isGoodCut(int[] sweetness, int K, int size) {
        int count = 0;
        int sum = 0;
        for (int sweet : sweetness) {
            sum += sweet;
            if (sum >= size) {
                count++;
                sum = 0;
            }
        }
        return count >= K + 1;
    }
}
