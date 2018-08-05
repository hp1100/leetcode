class Solution {
    public int projectionArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x_y = 0, y_z = 0, z_x = 0;
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++)
                if (grid[i][j] != 0)
                    x_y++;
        for (int i = 0; i < m; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                temp = Math.max(temp, grid[i][j]);
            }
            y_z += temp;
        }
        for (int j = 0; j < n; j++) {
            int temp = 0;
            for (int i = 0; i < m; i++) {
                temp = Math.max(temp, grid[i][j]);
            }
            z_x += temp;
        }
        return x_y + y_z + z_x;
    }
}
