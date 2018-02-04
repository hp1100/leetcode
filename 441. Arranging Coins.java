class Solution {
    public int arrangeCoins(int n) {
        int lo = 1, hi = n;
        while(lo <= hi){
            int mid = (hi - lo) / 2 + lo;
            if(0.5 * mid * (mid + 1) == n) return mid;
            if(0.5 * mid * (mid + 1) < n) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo - 1;
    }
}
