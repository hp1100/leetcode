public class Solution {
    
    //public boolean[][] used;
    
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        //defineUsed(board.length, board[0].length);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(backtrack(board, word, 0, i, j, used)) return true;
            }
        }
        return false;
    }
    
    // private void defineUsed(int row, int col){
    //     used = new boolean[row][col];    
    // }
    
    private boolean backtrack(char[][] board, String word, int idx, int i, int j, boolean[][] used){
        if(idx == word.length()) return true;
        if(i < 0 || i == board.length || j < 0 || j == board[0].length 
           || board[i][j] != word.charAt(idx) || used[i][j] == true) return false;
        used[i][j] = true;
        boolean isExist =  backtrack(board, word, idx + 1, i - 1, j, used) ||
            backtrack(board, word, idx + 1, i + 1, j, used) ||
            backtrack(board, word, idx + 1, i, j - 1, used) ||
            backtrack(board, word, idx + 1, i, j + 1, used);
        used[i][j] = false;
        return isExist;
    }
}
