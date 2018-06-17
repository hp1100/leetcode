class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int m = grid.length, n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        
        int res = 0;
        // up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {up[i][j] = 0; continue;}
                up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i > 0) up[i][j] += up[i - 1][j];
            }
        }
        // down
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {down[i][j] = 0; continue;}
                down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (i < m - 1) down[i][j] += down[i + 1][j];
            }
        }
        // left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'W') {left[i][j] = 0; continue;}
                left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j > 0) left[i][j] += left[i][j - 1];
            }
        }
        // right
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {right[i][j] = 0; continue;}
                right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                if (j < n - 1) right[i][j] += right[i][j + 1];
            }
        }
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if(grid[i][j] == '0')
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
        return res;
    }
}
