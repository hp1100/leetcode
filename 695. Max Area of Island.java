class Solution {
    
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;
    
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (grid[i][j] == 1) 
                    res = Math.max(res, dfs(grid, i, j));
        
        return res;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        
        grid[i][j] = 0;
        int count = 1;
        for (int[] d : dir)
            count += dfs(grid, i + d[0], j + d[1]);
        
        return count;
    }
}
