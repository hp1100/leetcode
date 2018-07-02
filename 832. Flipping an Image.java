class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j * 2 < n; j++) {
                int temp = A[i][j];
                A[i][j] = 1 - A[i][n - j - 1];
                A[i][n - j - 1] = 1 - temp;
            }
            //if (n % 2 == 1)
                //A[i][n / 2] = 1 - A[i][n / 2];
        }
        return A;
    }
}
