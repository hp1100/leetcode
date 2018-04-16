class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, len = citations.length, hi = len;
        while(lo < hi) {
            int mid = (hi - lo) / 2 + lo;
            if(citations[mid] >= (len - mid)) hi = mid;
            else lo = mid + 1;
        }
        return len - lo;
    }
}
