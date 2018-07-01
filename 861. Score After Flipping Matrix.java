class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 0) { // flip row
                for (int j = 0; j < n; j++) {
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        int base = 1;
        int res = 0;
        for (int j = n - 1; j >= 0; j--) {
            int count = 0;
            for (int i = 0; i < m; i++) {
                if (A[i][j] == 1)
                    count++;
            }
            res += Math.max(count, m - count) * base;
            base *= 2;
        }
        return res;
    }
}
