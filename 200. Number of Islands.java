// DFS (may overflow)
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j); //up
        dfs(grid, i + 1, j); //down
        dfs(grid, i, j - 1); //left
        dfs(grid, i, j + 1); //right
    }
}

// BFS
class Solution {
    
    class Coordinate {
        int x,y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int n = grid.length; // numbers of rows
        int m = grid[0].length; // numbers of columns
        int res = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    markByBfs(grid, i, j);
                    res++;
                }
            }
        }
        
        return res;
    }
    
    private void markByBfs(char[][] grid, int i, int j){
        int[] directionsX = {0, 1, -1, 0};
        int[] directionsY = {1, 0, 0, -1};
        
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(i, j));
        while(!queue.isEmpty()){
            Coordinate coor = queue.poll();
            for(int k = 0; k < 4; k++){
                Coordinate adj = new Coordinate(coor.x + directionsX[k], coor.y + directionsY[k]);
                if(!isBound(adj, grid) && grid[adj.x][adj.y] == '1'){
                    grid[adj.x][adj.y] = '0';
                    queue.offer(adj);
                }
            }
        }
    }
    
    private boolean isBound(Coordinate coor, char[][] grid){
        if(coor.x < 0 || coor.x >= grid.length) return true;
        if(coor.y < 0 || coor.y >= grid[0].length) return true;
        return false;
    }
}
