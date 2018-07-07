class Solution {
    
    private static int[][] delta = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
    
    public int numDistinctIslands(int[][] grid) {
        Set<List<List<Integer>>> islands = new HashSet<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                List<List<Integer>> island = new LinkedList<>();
                if (dfs(grid, i, j, i, j, m, n, island))
                    islands.add(island);
            }
        }
        return islands.size();
    }
    
    private boolean dfs(int[][] grid, int i0, int j0, int i, int j, int m, int n, List<List<Integer>> island) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return false;
        
        island.add(Arrays.asList(i - i0, j - j0));
        grid[i][j] = 0;
        for (int[] d: delta)
            dfs(grid, i0, j0, i + d[0], j + d[1], m, n, island);
        return true;
    }
}
