class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        
        for(int house: houses){
            int idx = Arrays.binarySearch(heaters, house);
            if(idx < 0){
                idx = ~idx;
                int d1 = idx - 1 >= 0 ? house - heaters[idx - 1] : Integer.MAX_VALUE;
                int d2 = idx < heaters.length ? heaters[idx] - house : Integer.MAX_VALUE;
                
                res = Math.max(res, Math.min(d1, d2));
            }
        }
        
        return res;
    }
}


// 2018.2.4
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int max = 0;
        for(int house: houses)
            max = Math.max(max, binarySearch(house, heaters));
        return max;
    }
    
    private int binarySearch(int house, int[] heaters){
        int lo = 0, hi = heaters.length-1;
        if(house < heaters[lo]) return heaters[lo] - house;
        if(house > heaters[hi]) return house - heaters[hi];
        while(lo + 1 < hi){
            int mid = (hi - lo) / 2 + lo;
            if(heaters[mid] == house) return 0;
            else if(heaters[mid] < house) lo = mid;
            else hi = mid;
        }
        return heaters[hi] - house > house - heaters[lo] ? house - heaters[lo] : heaters[hi] - house;
    }
}
