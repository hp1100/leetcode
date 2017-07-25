public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    islands++;
                    if(i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++;
                    if(j < grid[0].length - 1 && grid[i][j + 1] == 1) neighbours++;
                }
            }
        }
        return islands * 4 - neighbours * 2;
    }
}
