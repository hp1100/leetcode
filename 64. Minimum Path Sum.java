class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        // initialize first coloumn
        for(int i = 1; i < m; i++)
            grid[i][0] += grid[i - 1][0];
        // initialize first row
        for(int i = 1; i < n; i++)
            grid[0][i] += grid[0][i - 1];
        // dp (begin with the second row/col)
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
