class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        // initialize 
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                board[i][j] *= 2;
        // gaming 
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                board[i][j] = checkSurround(i, j, m, n, board);
        // return
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                board[i][j] %= 2;
    }
    
    private int checkSurround(int i, int j, int m, int n, int[][] board) {
        int count = 0;
        // pos:
        // 1 2 3
        // 4 x 5
        // 6 7 8
        if(i > 0 && j > 0 && board[i-1][j-1] >> 1 == 1) count++; // 1
        if(i > 0 && board[i-1][j] >> 1 == 1) count++; // 2
        if(i > 0 && j + 1 < n && board[i-1][j+1] >> 1 == 1) count++; // 3
        if(j > 0 && board[i][j-1] >> 1 == 1) count++; // 4
        if(j + 1 < n && board[i][j+1] >> 1 == 1) count++; // 5
        if(i + 1 < m && j > 0 && board[i+1][j-1] >> 1 == 1) count++; // 6
        if(i + 1 < m && board[i+1][j] >> 1 == 1) count++; // 7
        if(i + 1 < m && j + 1 < n && board[i+1][j+1] >> 1 == 1) count++; // 8
        //System.out.println(count);
        
        if(board[i][j] >> 1 == 1)  // live cell
            return (count == 2 || count == 3) ? 3 : 2;
        else // dead cell
            return count == 3 ? 1 : 0;
    }
}
