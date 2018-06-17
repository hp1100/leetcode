class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null 
           || obstacleGrid.length == 0 
           || obstacleGrid[0].length == 0 
           || obstacleGrid[0][0] == 1) 
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp  = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) 
                    dp[i][j] = 1;
                else if(obstacleGrid[i][j] == 1) 
                    dp[i][j] = 0;
                else{
                    int upPaths, leftPaths;
                    upPaths = i > 0 ? dp[i - 1][j] : 0;
                    leftPaths = j > 0 ? dp[i][j - 1] : 0;
                    //System.out.println(i + " U:" + upPaths + " L:" + leftPaths);
                    dp[i][j] = upPaths + leftPaths;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
