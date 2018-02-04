/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while(lo < hi){
            int mid = (lo + hi) >>> 1;
            if(isBadVersion(mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
}
