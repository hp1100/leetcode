class Solution {
    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while(lo < hi){
            int mid = (hi - lo) / 2 + lo;
            if(!enough(mid, m, n, k))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
    
    private boolean enough(int x, int m, int n, int k){
        int count = 0;
        for(int i = 1; i <= m; i++){
            count += Math.min(x / i, n);
        }
        return count >= k;
    }
}
