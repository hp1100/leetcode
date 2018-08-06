class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt=0;
        for(int i=0;i<=grid.length-3;i++)
            for(int j=0;j<=grid[0].length-3;j++)
                if(helper(i,j,grid)) cnt++;
            
        return cnt;
    }  
    
    private boolean helper(int x,int y,int[][] grid){
        if(grid[x+1][y+1]!=5) return false;
        
        int[] valid=new int[16];
        
        for(int i=x;i<=x+2;i++)
            for(int j=y;j<=y+2;j++)
                valid[grid[i][j]]++;
            
        for (int v = 1; v <= 9; v++)
            if (valid[v] != 1) return false;
        
        if((grid[x][y]+grid[x][y+1]+grid[x][y+2])!=15)         return false;
        if((grid[x][y]+grid[x+1][y+1]+grid[x+2][y+2])!=15)     return false;
        if((grid[x][y]+grid[x+1][y]+grid[x+2][y])!=15)         return false;
        if((grid[x+2][y]+grid[x+2][y+1]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+2]+grid[x+2][y+2])!=15)   return false;
        if((grid[x][y+2]+grid[x+1][y+1]+grid[x+2][y])!=15)     return false;
        return true;
    }
}
