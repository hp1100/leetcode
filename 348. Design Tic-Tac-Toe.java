class TicTacToe {
    
    int[] rows, cols;
    int diagonal, anti_diagonal;
    int n;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
        diagonal = anti_diagonal = 0;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int turn = player == 1 ? 1 : -1;
        
        if (row == col) anti_diagonal += turn;
        if (row + col == n - 1) diagonal += turn;
        rows[row] += turn;
        cols[col] += turn;
        
        boolean res = Math.abs(rows[row]) == n ||  Math.abs(cols[col]) == n ||
                      Math.abs(diagonal) == n || Math.abs(anti_diagonal) == n;
        return res ? player : 0;
    }
}
