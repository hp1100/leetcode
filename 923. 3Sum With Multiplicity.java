class Solution {
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int res = 0, len = A.length, mod = 1000000007;
        for (int i = 0; i < len - 2; i++) {
            int lo = i + 1, hi = len - 1;
            while (lo < hi) {
                if (A[i] + A[lo] + A[hi] < target) {
                    lo++;
                } else if (A[i] + A[lo] + A[hi] > target) {
                    hi--;
                } else {
                    if (A[lo] == A[hi]) {
                        int diff = hi - lo;
                        res = (res + diff * (diff + 1) / 2) % mod;
                        break;
                    } 
                    int countLeft = 1, countRight = 1;
                    while (lo < hi && A[lo] == A[++lo]) countLeft++;
                    while (lo < hi && A[hi] == A[--hi]) countRight++;
                    res = (res + countLeft * countRight) % mod;
                }
            }
        }
        return res;
    }
}
