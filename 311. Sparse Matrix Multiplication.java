class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int a = A.length, b = A[0].length, c = B[0].length;
        int[][] AB = new int[a][c];

        for(int i = 0; i < a; i++) {
            for(int k = 0; k < b; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < c; j++) {
                        if (B[k][j] != 0) AB[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return AB;   
    }
}
