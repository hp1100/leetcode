class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        transpose(matrix);
        flip(matrix);
    }
    
    private void transpose(int[][] matrix){
        int n = matrix.length;
        int[][] rvalue = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
    }
    
    private void flip(int[][] matrix){
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                matrix[i][j] ^= matrix[i][n-j-1];
                matrix[i][n-j-1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][n-j-1];
            }
        }
    }
}
