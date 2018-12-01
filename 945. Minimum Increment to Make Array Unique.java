class Solution {
    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0 || A.length == 1) return 0;
        Arrays.sort(A);
        int res = 0, min = A[0] + 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= min) {
                res += min - A[i];
                A[i] = min;
            }
            min = A[i] + 1;
        }
        return res;
    }
}
