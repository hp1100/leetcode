// Time Complexity : O(n^4)
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length, res = 0;
        int[][] Ap = new int[3 * n][3 * n];
        for (int i = n; i < 2 * n; i++) {
            for (int j = n; j < 2 * n; j++) {
                Ap[i][j] = A[i - n][j - n];
            }
        }
        for (int i = 0; i <= 2 * n; i++) { 
            for (int j = 0; j <= 2 * n; j++) {
                res = Math.max(res, helper(Ap, B, i, j));
            }
        }
        return res;
    }
    
    private int helper(int[][] A, int[][] B, int x, int y) { // O(n^2)
        int n = B.length, sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += B[i][j] * A[x + i][y + j];
            }
        }
        return sum;
    }
}
