class Solution {
    
    Double DIFF = 0.000001;
    
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 0;
        
        for (int i = 1; i < stations.length; i++)
            hi = Math.max(hi, stations[i] - stations[i - 1]);
        
        while (hi - lo >= DIFF) {
            double mid = (lo + hi) / 2;
            if (helper(stations, K, mid)) {
                hi = mid; 
            } else {
                lo = mid;
            }
        }
        
        return lo;
    }
    
    private boolean helper(int[] stations, int K, double min_dis) {
        int count = 0;
        for (int i = 1; i < stations.length; i++) {
            double dis = stations[i] - stations[i - 1];
            if (dis <= min_dis) continue;
            count += Math.ceil(dis/min_dis) - 1;
            if (count > K) return false;
        }
        return true;
    }
    
    
}
