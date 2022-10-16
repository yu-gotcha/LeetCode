class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0);
    }
    
    public int queens(boolean[][] board, int row){
        int count = 0;
        if(row == board.length) return 1;
        
        for (int col = 0; col < board.length; col++) {
            if(isSafe(board,row,col)){
                board[row][col] = true;
                count += queens(board, row+1);
                board[row][col] = false;
            }
        }
        
        return count;
    }
    
    public boolean isSafe(boolean[][] board, int row, int col){
        for (int i = 0; i < row; i++) {
            if(board[i][col]) return false;
        }
        
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row - i][col - i]) return false;
        }
        
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row - i][col + i]) return false;
        }
        
        return true;
    }
}